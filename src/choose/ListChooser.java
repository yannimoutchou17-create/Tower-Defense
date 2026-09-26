package choose;

import board.Board;
import board.Position;
import choose.action.Action;

import java.util.List;
/**
 * Interface ListChooser
 */
public interface ListChooser<T extends Action> {
    Action choose(String p, List<T> options);
    Position choosePosition(Board board);
}