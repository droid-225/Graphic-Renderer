import GameEngine.Coordinate;
import GameEngine.Entities.Player;
import GameEngine.GameHandler;
import PhysicsEngine.PhysicsHandler;

public class Main {
	public static void main(String[] args) {
		//GameHandler game = new GameHandler();
		PhysicsHandler physics = new PhysicsHandler();

		physics.start();
		//game.startGame();
	}
}