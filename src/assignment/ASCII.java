package assignment;

/**
 *
 * @author Alvina Angelin 22152692
 */
public class ASCII {
    
    public static void Dog() {
        System.out.println("    ___");
        System.out.println(" __/_  `.  .-\"\"\"-.");
        System.out.println(" \\_,` | \\-'  /   )`-')");
        System.out.println("  \"\") `\"`    \\  ((`\"`");
        System.out.println(" ___Y  ,    .'7 /|");
        System.out.println("(_,___/...-` (_/_/");
    }
    
    public static void Cat() {
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
    
    public static void Hamster() {
        System.out.println("   _-'-\"\"--o ");
        System.out.println(" ,\"\" _      \".");
        System.out.println(",)____)___),-'");
    }
    
    public static void Rabbit() {
        System.out.println("          ((`\\");
        System.out.println("       ___ \\\\ '--._");
        System.out.println("    .'`   `'    o  )");
        System.out.println("   /    \\   '. __.'");
        System.out.println("  _|    /_  \\ \\_\\_");
        System.out.println(" {_\\______\\-'\\__\\_\\");
    }
    
    public static void printAnimal(Animal animal) {
        Species species = animal.getSpecies();
        switch (species) {
            case DOG:
                Dog();
                break;
            case CAT:
                Cat();
                break;
        }
    }

}
