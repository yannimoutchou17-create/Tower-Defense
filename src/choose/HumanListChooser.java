package choose;
import board.Board;
import board.Position;
import choose.action.Action;
import java.util.List;
import java.util.Scanner;

public class HumanListChooser<T extends choose.action.Action> implements ListChooser<T> {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public T choose(String prompt, List<T> options) {
        System.out.println("\n" + prompt);
        for (int i = 0; i < options.size(); i++) {
            // TODO:cree une classe abstraite action qui a une methode abstraite getDescription() et execute(GameContext)  de cette action et svp faites pas les methodes action dans cette classe chooser
            System.out.println("  " + i + ". " + options.get(i).getDescription());
        }
        System.out.print("Votre choix : ");

        int index = -1;
        while (index < 0 || index >= options.size()) {
            try {
                index = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.print("Index invalide, réessaie : ");
            }
        }
        return options.get(index);
    }


    @Override
    public Position choosePosition(Board board) {
        System.out.print("Entrez la ligne (row) de la tour : ");
        int row = -1;
        while (row < 0 || row >= board.getHeight()) {
            try { row = scanner.nextInt(); }
            catch (Exception e) { scanner.nextLine(); System.out.print("Valeur invalide, réessaie : "); }
        }
        System.out.print("Entrez la colonne (col) de la tour : ");
        int col = -1;
        while (col < 0 || col >= board.getWidth()) {
            try { col = scanner.nextInt(); }
            catch (Exception e) { scanner.nextLine(); System.out.print("Valeur invalide, réessaie : "); }
        }
        if (!board.isCellAvailable(row, col)) {
            System.out.println("Case non disponible, placement automatique.");
            return board.findAvailablePosition();
        }
        return new Position(row, col);
    }
}
