package pacman.viewer;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import pacman.util.PacmanTheme;

/**
 * Contains a utility for creating Swing components in the application.
 *
 * @version 1.0
 */
public class PacmanViewUtility {
    /**
     * Adds a hovering effect to a JButton.
     *
     * @param button the JButton object
     */
    public static void addMouseHoveringEffectAtStart(JButton button) {
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setBackground(PacmanTheme.BUTTON_HOVERED);
        button.setForeground(PacmanTheme.WELCOME_TEXT);
        button.setFont(new Font("Dialog", Font.BOLD, 26));
        button.setBorder(BorderFactory.createLineBorder(PacmanTheme.WELCOME_TEXT, 2));

        button.addMouseListener(new MouseAdapter() {
            /**
             * Invoked when the mouse enters a component.
             *
             * @param evt the mouse enter event
             */
            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setOpaque(true);
                button.setBackground(PacmanTheme.BUTTON_HOVERED);
            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param evt the mouse pressed event
             */
            @Override
            public void mousePressed(final MouseEvent evt) {
                button.setBackground(PacmanTheme.BUTTON_PRESSED);
            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param evt the mouse release event
             */
            @Override
            public void mouseReleased(final MouseEvent evt) {
                this.mouseEntered(evt);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param evt the mouse exit event
             */
            @Override
            public void mouseExited(MouseEvent evt) {
                button.setOpaque(false);
            }
        });
    }

    /**
     * Adds a hovering effect to a JButton.
     *
     * @param button the JButton object
     */
    public static void addMouseHoveringEffectAtGame(JButton button) {
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setBackground(PacmanTheme.BUTTON_PRESSED);
        button.setForeground(PacmanTheme.GAME_TEXT);
        button.setFont(new Font("Dialog", Font.BOLD, 17));
        button.setBorder(BorderFactory.createLineBorder(PacmanTheme.GAME_TEXT, 2));

        button.addMouseListener(new MouseAdapter() {
            /**
             * Invoked when the mouse enters a component.
             *
             * @param evt the mouse enter event
             */
            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setOpaque(true);
                button.setBackground(PacmanTheme.BUTTON_PRESSED);
            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param evt the mouse pressed event
             */
            @Override
            public void mousePressed(final MouseEvent evt) {
                button.setBackground(PacmanTheme.BUTTON_HOVERED);
            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param evt the mouse release event
             */
            @Override
            public void mouseReleased(final MouseEvent evt) {
                this.mouseEntered(evt);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param evt the mouse exit event
             */
            @Override
            public void mouseExited(MouseEvent evt) {
                button.setOpaque(false);
            }
        });
    }

}
