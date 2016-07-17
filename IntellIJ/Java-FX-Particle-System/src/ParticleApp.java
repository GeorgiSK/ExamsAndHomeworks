import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParticleApp extends Application {
    private Emitter emitter = new FireEmitter();
    private List<Particle> particles = new ArrayList<>();
    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContext()));
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        timer.start();
    }

    private void onUpdate() {
        gc.setGlobalAlpha(1.0);
        gc.setGlobalBlendMode(BlendMode.SRC_OVER);
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 600, 600);



        particles.addAll(emitter.emit(300, 300));

        for (Iterator<Particle> it = particles.iterator(); it.hasNext(); ) {
            Particle p = it.next();
            p.update();

            if (!p.isAlive()) {
                it.remove();
                continue;
            }

            p.draw(gc);
        }
    }

    private Parent createContext() {
        Pane root = new Pane();
        root.setPrefSize(600, 600);

        Canvas canvas = new Canvas(600, 600);
        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();

        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
