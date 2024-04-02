package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Text text = new Text(10, 20, "Points: 0");
        pane.getChildren().add(text);

        AtomicInteger points = new AtomicInteger();

        pane.setPrefSize(WIDTH, HEIGHT);

        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        List<Asteroid> asteroids = new ArrayList<>();
        List<Projectile> projectiles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            Asteroid asteroid = new Asteroid(rnd.nextInt(WIDTH / 3), rnd.nextInt(HEIGHT));
            asteroids.add(asteroid);
        }

        pane.getChildren().add(ship.getCharacter());
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));

        Scene scene = new Scene(pane);
        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();

        // Key handling
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                // Controlling the ship and rotating
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }

                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }

                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }

                // Shooting projectiles
                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);

                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                    pane.getChildren().add(projectile.getCharacter());
                }

                // Detecting collisions and removing asteroids
                projectiles.forEach(projectile -> {
                    List<Asteroid> collisions = asteroids.stream()
                            .filter(asteroid -> asteroid.collide(projectile))
                            .collect(Collectors.toList());

                    collisions.stream().forEach(collided -> {
                        asteroids.remove(collided);
                        pane.getChildren().remove(collided.getCharacter());
                    });
                });

                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());

                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if (projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                        }
                    });

                    if (!projectile.isAlive()) {
                        text.setText("Points: " + points.addAndGet(1000));
                    }
                });

                projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
                projectiles.removeAll(projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .collect(Collectors.toList()));

                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
                asteroids.removeAll(asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .collect(Collectors.toList()));

                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });

                // Add new asteroids randomly
                if (Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if (!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        launch(AsteroidsApplication.class);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }

}
