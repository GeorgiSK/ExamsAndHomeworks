import java.util.*;

public class DragonEra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long numOfDragons = Integer.parseInt(scanner.nextLine());

        ArrayList<Dragon> dragons = new ArrayList<>();

        for (long i = 0; i < numOfDragons; i++) {
            String dragonName = "Dragon_" + (i + 1);
            long numOfEggs = Integer.parseInt(scanner.nextLine());
            Dragon currentDragon = new Dragon(dragonName);
            dragons.add(currentDragon);

            for (long j = 0; j < numOfEggs; j++) {
                currentDragon.addEgg();
            }

        }

        int numOfYears = Integer.parseInt(scanner.nextLine());
        String[] yearTypes = new String[numOfYears];
        for (int i = 0; i < yearTypes.length; i++) {
            yearTypes[i] = scanner.nextLine().trim();
        }
        numOfDragons++;

        for (int i = 0; i < yearTypes.length; i++) {
            final int loop = dragons.size();

            for (int j = 0; j < dragons.size(); j++) {
                Dragon currentDragon = dragons.get(j);
                for (int k = 0; k < currentDragon.eggs.size(); k++) {
                    Egg currentEgg = currentDragon.eggs.get(k);
                    currentEgg.addAge();
                }
                currentDragon.addAge();
            }
            for (int j = 0; j < loop; j++) {
                Dragon currentDragon = dragons.get(j);
                if (currentDragon.age < 6) {

                    if (currentDragon.age == 3 || currentDragon.age == 4) {
                        currentDragon.addEgg();
                    }

                    for (int x = 0; x < currentDragon.eggs.size(); x++) {
                        Egg currentEgg = currentDragon.eggs.get(x);

                        if (currentEgg.age >= 2 && currentEgg.isHatched == false) {
                            if (yearTypes[i].equals("Bad")) {
                                currentEgg.isHatched = true;
                                continue;
                            }

                            if (yearTypes[i].equals("Normal")) {
                                String indent = new String(new char[currentDragon.indent]).replace("\0", " ");
                                String newDragonName = indent + currentDragon.name + "/" + "Dragon_" + numOfDragons;
                                dragons.add(new Dragon(newDragonName));
                                currentEgg.isHatched = true;
                                numOfDragons++;
                            } else if (yearTypes[i].equals("Good")) {
                                String indent = new String(new char[currentDragon.indent]).replace("\0", " ");
                                String newDragonName = indent + currentDragon.name + "/" + "Dragon_";
                                dragons.add(new Dragon(newDragonName + numOfDragons));
                                numOfDragons++;
                                dragons.add(new Dragon(newDragonName + numOfDragons));
                                numOfDragons++;
                                currentEgg.isHatched = true;
                            }
                        }
                    }
                }else {
                    currentDragon.isAlive = false;
                }
            }


        }

        for (int i = 0; i < dragons.size(); i++) {
            if (dragons.get(i).isPrinted == false) {
                System.out.println(dragons.get(i).name);
                dragons.get(i).isPrinted = true;
            }

            for (int j = 0; j < dragons.size(); j++) {
                if (dragons.get(j).name.startsWith(dragons.get(i).name)) {
                    if (dragons.get(j).isPrinted == false) {
                        System.out.println(" " + dragons.get(j).name);
                        dragons.get(j).isPrinted = true;
                    }
                }
            }
        }


    }
}

class Dragon {
    int age;
    String name;
    boolean isAlive;
    List<Egg> eggs;
    boolean isPrinted;
    int indent;

    public Dragon(String name) {
        this.age = 0;
        this.name = name;
        this.isAlive = true;
        this.eggs = new ArrayList<>();
        this.isPrinted = false;
        this.indent = 0;
    }

    public void addAge() {
        this.age++;
    }

    public void addEgg() {
        this.eggs.add(new Egg());
    }
}

class Egg {
    int age;
    boolean isHatched;

    public Egg() {
        this.age = 0;
        this.isHatched = false;
    }

    public void addAge() {
        this.age++;
    }
}
