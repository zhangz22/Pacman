package pacman.agents;

import pacman.algorithms.AbstractAlgorithm;
import pacman.controller.PacmanMazeController;
import pacman.model.Direction;
import pacman.model.Maze;
import pacman.util.ImageInterning;

import java.awt.*;
import java.io.IOException;

import static pacman.agents.MazePanel.BLOCK_SIZE;

public class PacmanAgent extends AbstractAgent {

    /** the algorithm chosen for determining next move. **/
    private final AbstractAlgorithm algorithm;

    protected final int index;

    /**
     * Constructor that creates a new PacmanAgent.
     *
     * @param controller  the controller of the application
     * @param maze            the game maze
     * @param startCoordinateX the start x coordinate of the icon in the board
     * @param startCoordinateY the start y coordinate of the icon in the board
     * @param index the index of the pacman
     * @param algorithm  the algorithm chosen for determining next move
     */
    public PacmanAgent(final PacmanMazeController controller, final Maze maze,
                       final int startCoordinateX, final int startCoordinateY,
                       final int index, final AbstractAlgorithm algorithm) {
        super(controller, maze, startCoordinateX, startCoordinateY, 30);
        try {
            rightIcon = ImageInterning.getImageIconFromFile("pacman_right.gif",
                    new Dimension(BLOCK_SIZE, BLOCK_SIZE));
            leftIcon = ImageInterning.getImageIconFromFile("pacman_left.gif",
                    new Dimension(BLOCK_SIZE, BLOCK_SIZE));
            upIcon = ImageInterning.getImageIconFromFile("pacman_up.gif",
                    new Dimension(BLOCK_SIZE, BLOCK_SIZE));
            downIcon = ImageInterning.getImageIconFromFile("pacman_down.gif",
                    new Dimension(BLOCK_SIZE, BLOCK_SIZE));
        } catch (IOException e) {
            throw new RuntimeException("Irrecoverable error: " + e.getMessage());
        }
        setIcon(rightIcon);
        this.index = index;
        this.algorithm = algorithm;
    }

    /**
     * Find the next direction before moving at each step.
     *
     * @param currDirection the current direction
     */
    @Override
    protected void checkPossibleNextDirection(final Direction currDirection) {
        changeDirection(this.algorithm.getPacmanAction(index, coordinateX,
                coordinateY));
    }

    public int getIndex() {
        return index;
    }
}