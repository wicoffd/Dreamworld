package controller;

import view.CustomTitle;

import javax.swing.*;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static view.Window.frame;

public class KeyManager {
    MoveListener moveListener = new MoveListener();
    public KeyManager(JFrame frame, JButton title) {
        //frame.addMouseListener(moveListener);
        //frame.addMouseMotionListener(moveListener);
        title.addMouseListener(moveListener);
        title.addMouseMotionListener(moveListener);
    }




    private class MoveListener implements MouseListener, MouseMotionListener {
        // inspired by https://stackoverflow.com/questions/66929223/how-to-move-an-undecorated-jframe-window
        private Point clickPoint;
        private Rectangle frameBounds;
        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param event the event to be processed
         */
        @Override
        public void mouseClicked(MouseEvent event) {

        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param event the event to be processed
         */
        @Override
        public void mousePressed(MouseEvent event) {

                frameBounds = frame.getBounds();
                clickPoint = event.getPoint();

        }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param event the event to be processed
         */
        @Override
        public void mouseReleased(MouseEvent event) {
            moveFrame(event);
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseEntered(MouseEvent e) {

        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseExited(MouseEvent e) {

        }

        /**
         * Invoked when a mouse button is pressed on a component and then
         * dragged.  {@code MOUSE_DRAGGED} events will continue to be
         * delivered to the component where the drag originated until the
         * mouse button is released (regardless of whether the mouse position
         * is within the bounds of the component).
         * <p>
         * Due to platform-dependent Drag&amp;Drop implementations,
         * {@code MOUSE_DRAGGED} events may not be delivered during a native
         * Drag&amp;Drop operation.
         *
         * @param event the event to be processed
         */
        @Override
        public void mouseDragged(MouseEvent event) {
            moveFrame(event);
        }

        /**
         * Invoked when the mouse cursor has been moved onto a component
         * but no buttons have been pushed.
         *
         * @param e the event to be processed
         */
        @Override
        public void mouseMoved(MouseEvent e) {

        }

        private void moveFrame(MouseEvent event) {

                Point endPoint = event.getPoint();
                int xDiff = endPoint.x - clickPoint.x;
                int yDiff = endPoint.y - clickPoint.y;
                frameBounds.x += xDiff;
                frameBounds.y += yDiff;
                frame.setBounds(frameBounds);

        }
    }

}