import javafx.geometry.Point2D;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class FireEmitter extends Emitter {
    @Override
    public List<Particle> emit(double x, double y) {
        List<Particle> particles = new ArrayList<>();
        int numOfParticles = 5;

        for (int i = 0; i < numOfParticles; i++) {
            Particle p = new Particle(x, y, new Point2D((Math.random() - 0.5), Math.random() * -5),
                    10, 0.5, Color.rgb(50, 50, 250), BlendMode.ADD);
            particles.add(p);
        }
        return particles;
    }
}
