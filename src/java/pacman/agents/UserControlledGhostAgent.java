package pacman.agents;

import pacman.algorithms.AbstractAlgorithm;
import pacman.controller.PacmanMazeController;
import pacman.model.Maze;

/**
 * This is a component that shows a user controlled ghost in the game with
 * moving animations.
 *
 * @version 1.0
 */
public class UserControlledGhostAgent extends ControlledGhostAgent {

    /**
     * Constructor that creates a new PacmanAgent.
     *
     * @param controller  the controller of the application
     * @param maze            the game maze
     * @param startCoordinateX the start x coordinate of the icon in the board
     * @param startCoordinateY the start y coordinate of the icon in the board
     * @param name             name of the ghost
     * @param algorithm  the algorithm chosen for determining next move
     */
    public UserControlledGhostAgent(final PacmanMazeController controller, final Maze maze,
        final int startCoordinateX, final int startCoordinateY,
        final String name, AbstractAlgorithm algorithm) {
        super(controller, maze, startCoordinateX, startCoordinateY, name, algorithm);
        this.setArrowKeyToControl(this);
    }

    /**
     * Let AI takes over from the user.
     *
     * @return {@code true} if the user is no longer in control and {@code false}
     *      otherwise
     */
    @Override
    public boolean aiTakeOver() {
        super.aiTakeOver();
        if (!aiTakeOver) {
            disableArrowKeyToControl(this);
        } else {
            setArrowKeyToControl(this);
        }
        return aiTakeOver;
    }
}
