
import java.util.Scanner;

public class UserInputController {
	private static enum MenuAction {
		ADD_WORD, SEARCH_WORD, EXIT
	}

	private Dictionary dictionary;
	private Scanner scanner;

	public UserInputController() {
		dictionary = new Dictionary();
		scanner = new Scanner(System.in);
	}

	public void start() {
		MenuAction selectedMenuAction = MenuAction.EXIT;
		do {
			selectedMenuAction = showMenu();

			switch (selectedMenuAction) {
			case ADD_WORD:
				addWord();
				break;
			case SEARCH_WORD:
				searchWord();
				break;
			default:
			}

		} while (selectedMenuAction != MenuAction.EXIT);

		scanner.close();

		System.out.println("Thank you for using Dictionary 2015! Bye!");
	}

	private MenuAction showMenu() {
		System.out.println("Menu");
		System.out.println("----");
		System.out.println();
		System.out.println("1. Add word");
		System.out.println("2. Search word");
		System.out.println("3. Exit");
		int selectedOption = 0;
		do {
			System.out.print("Enter option: ");
			try {
				selectedOption = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception ex) {
				scanner.next();
				System.out.println("Please enter a number");
			}
		} while (selectedOption < 1 || selectedOption > 3);

		switch (selectedOption) {
		case 1:
			return MenuAction.ADD_WORD;
		case 2:
			return MenuAction.SEARCH_WORD;
		default:
			return MenuAction.EXIT;
		}
	}

	private void addWord() {
		System.out
				.print("Enter word and translation (<word> = <translation>): ");
		String line = scanner.nextLine();
		String[] tokens = line.split("=");
		if (tokens.length == 2) {
			WordEntity wordEntity = new WordEntity(tokens[0].trim(),
					tokens[1].trim());
			dictionary.addEntity(wordEntity);
			System.out.println(wordEntity.getWord() + " was added");
		}
	}

	private void searchWord() {
		System.out.print("Enter word to search: ");
		String line = scanner.nextLine();
		WordEntity wordEntity = dictionary.searchWord(line);
		if (wordEntity != null) {
			System.out
					.println("Translation is: " + wordEntity.getTranslation());
		} else {
			System.out.println("Word " + line + " is not found");
		}
	}

}
