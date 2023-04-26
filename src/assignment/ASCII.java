package assignment;

/** @author Alvina Angelin 22152692 */
public class ASCII {

    private static void printDog() {
        System.out.println("    ___");
        System.out.println(" __/_  `.  .-\"\"\"-.");
        System.out.println(" \\_,` | \\-'  /   )`-')");
        System.out.println("  \"\") `\"`    \\  ((`\"`");
        System.out.println(" ___Y  ,    .'7 /|");
        System.out.println("(_,___/...-` (_/_/");
    }

    private static void printCat() {
        System.out.println(" ,_     _");
        System.out.println(" |\\\\_,-~/");
        System.out.println(" / _  _ |    ,--.");
        System.out.println("(  @  @ )   / ,-'");
        System.out.println(" \\  _T_/-._( (");
        System.out.println(" /         `. \\");
        System.out.println("|         _  \\ |");
        System.out.println(" \\ \\ ,  /      |");
        System.out.println("  || |-_\\__   /");
        System.out.println(" ((_/`(____,-'");
    }

    private static void printHamster() {
        System.out.println("   _-'-\"\"--o ");
        System.out.println(" ,\"\" _      \".");
        System.out.println(",)____)___),-'");
    }

    private static void printRabbit() {
        System.out.println("          ((`\\");
        System.out.println("       ___ \\\\ '--._");
        System.out.println("    .'`   `'    o  )");
        System.out.println("   /    \\   '. __.'");
        System.out.println("  _|    /_  \\ \\_\\_");
        System.out.println(" {_\\______\\-'\\__\\_\\");
    }
    
    private static void printFrog() {
        System.out.println("              _    ");
        System.out.println("  __   ___.--'_`. ");
        System.out.println(" ( _`.'. -   'o` ) ");
        System.out.println(" _\\.'_'      _.-'");
        System.out.println("( \\`. )    //\\`   ");
        System.out.println(" \\_`-'`---'\\\\__,  ");
        System.out.println("  \\`        `-\\ ");
        System.out.println("   `               ");
    }

    public static void printAnimal(Animal animal) {
        Species species = animal.getSpecies();
        switch (species) {
            case DOG:
                printDog();
                break;
            case CAT:
                printCat();
                break;
            case HAMSTER:
                printHamster();
                break;
            case RABBIT:
                printRabbit();
                break;
            case FROG:
                printFrog();
                break;
        }
    }

}
