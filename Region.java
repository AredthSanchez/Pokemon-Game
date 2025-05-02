import java.util.Random;

public class Region{
    private String name;
    private String climate;
    private int difficulty;
    private Trainer[] trainerInRegion;
    private int trainerCount;
    private Pokemon[] wildPokemon;
    private int wildCount;

    public Region(String name, String climate, int difficulty){
        this.name = name;
        this.climate = climate;
        this.difficulty = difficulty;
        this.trainerInRegion = new Trainer[10];
        this.trainerCount = 0;
        this.wildPokemon = new Pokemon[20];
        this.wildCount = 0;
    }
    public Region(String name, String climate, int difficulty, Trainer[] trainers){
        this.name = name;
        this.climate = climate;
        this.difficulty = difficulty;
        this.trainerInRegion = new Trainer[10];
        this.trainerCount = 0;
        this.wildPokemon = new Pokemon[20];
        this.wildCount = 0;
        
        // for getting trainer count
        for(int i = 0; i < trainers.length && i < 10; i++){
            this.trainerInRegion[i] = trainers[i];
            this.trainerCount++;
        }
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getClimate(){
        return climate;
    }
    public void setClimate(String climate){
        this.climate = climate;
    }
    public int getDifficulty(){
        return difficulty;
    }
    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }
    public Trainer[] getTrainerInRegion(){
        return trainerInRegion;
    }
    public void setTrainerInRegion(Trainer[] trainers){
        this.trainerInRegion = new Trainer[10];
        this.trainerCount = 0;
        for(int i = 0; i < trainers.length && i < 10; i++){
            this.trainerInRegion[i] = trainers[i];
            this.trainerCount++;
        }
    }
    public Pokemon[] getWildPokemon(){
        return wildPokemon;
    }
    public void setWildPokemon(Pokemon[] wilds){
        this.wildPokemon = new Pokemon[20];
        this.wildCount = 0;
        for(int i = 0; i < wilds.length && i < 20; i++){
            this.wildPokemon[i] = wilds[i];
            this.wildCount++;
        }
    }
    public boolean addTrainer(Trainer t){
        if(trainerCount < 10){
            trainerInRegion[trainerCount] = t;
            trainerCount++;
            return true;
        }
        return false;
    }
    public boolean removeTrainer(String name){
        for(int i = 0; i < trainerCount; i++){
            if(trainerInRegion[i] != null && trainerInRegion[i].getName().equals(name)){
                for(int j = i; j < trainerCount-1; j++){
                    trainerInRegion[j] = trainerInRegion[j + 1];
                }
                trainerInRegion[trainerCount-1] = null;
                trainerCount--;
                return true;
            }
        }
        return false;
    }
    public boolean addWildPokemon(Pokemon p){
        if(wildCount < 20){
            wildPokemon[wildCount] = p;
            wildCount++;
            return true;
        }
        return false;
    }
    public boolean removeWildPokemon(String name){
        for(int i = 0; i < wildCount; i++){
            if(wildPokemon[i] != null && wildPokemon[i].getName().equals(name)){
                for(int j = i; j < wildCount-1; j++){
                    wildPokemon[j] = wildPokemon[j + 1];
                }
                wildPokemon[wildCount - 1] = null;
                wildCount--;
                return true;
            }
        }
        return false;
    }
    public Pokemon generateWildPokemon(){
        if(wildCount == 0){
            return null;
        }
        Random rand = new Random();
        return wildPokemon[rand.nextInt(wildCount)];
    }
    public void describeRegion(){
        System.out.println("Region: " + name);
        System.out.println("Climate: " + climate);
        System.out.println("Difficulty Level: " + difficulty);
    }
    public void getDetails(){
        System.out.println("Wild Pokemon in " + name + ":");
        for(int i = 0; i < wildCount; i++){
            if(wildPokemon[i] != null){
                wildPokemon[i].getDetails();
                System.out.println();
            }
        }
    }
    public void simulateInteraction(String trainerA, String trainerB){
        Trainer t1 = null;
        Trainer t2 = null;
        
        for(int i = 0; i < trainerCount; i++){
            if(trainerInRegion[i] != null){
                if(trainerInRegion[i].getName().equals(trainerA)){
                    t1 = trainerInRegion[i];
                }
                if(trainerInRegion[i].getName().equals(trainerB)){
                    t2 = trainerInRegion[i];
                }
            }
        }
        if(t1 == null || t2 == null){
            System.out.println("One or both trainers not found in the region.");
            return;
        }
        System.out.println("Simulating interaction between " + t1.getName() + " and " + t2.getName() + "...");
        
        if(t1.getPartner() == null){
            System.out.println(t1.getName());
        }
        if(t2.getPartner() == null){
            System.out.println(t2.getName());
        }

        if(t1.getPartner() != null && t2.getPartner() != null){
            Pokemon p1 = t1.getPartner();
            Pokemon p2 = t2.getPartner();
            
            int p1OriginalHealth = p1.getHealth();
            int p2OriginalHealth = p2.getHealth();
            
            boolean battleOver = false;
            while(!battleOver && p1.getHealth() > 0 && p2.getHealth() > 0){
                System.out.println(t1.getName() + " attacks with " + p1.getName() + " (Level " + p1.getLevel() + ")");
                int damage1 = calculateDamage(p1, p2);
                int newHealth2 = p2.getHealth() - damage1;
                p2.setHealth(newHealth2);
                System.out.println(p2.getName() + " health reaches " + p2.getHealth() + " pts");
                
                if(p2.getHealth() <= 0){
                    System.out.println(p2.getName() + " health reaches below 0 pts");
                    System.out.println(p1.getName() + " Wins!");
                    battleOver = true;
                }else{
                    System.out.println(t2.getName() + " attacks with " + p2.getName() + " (Level " + p2.getLevel() + ")");
                    int damage2 = calculateDamage(p2, p1);
                    int newHealth1 = p1.getHealth() - damage2;
                    p1.setHealth(newHealth1);
                    System.out.println(p1.getName() + " health reaches " + p1.getHealth() + " pts");
                    
                    if(p1.getHealth() <= 0){
                        System.out.println(p1.getName() + " health reaches below 0 pts");
                        System.out.println(p2.getName() + " Wins!");
                        battleOver = true;
                    }
                }
            }
            p1.setHealth(p1OriginalHealth);
            p2.setHealth(p2OriginalHealth);
        }
    }
    private int calculateDamage(Pokemon attacker, Pokemon defender){
        String attackType = attacker.getType();
        String deffenseType = defender.getType();
        int baseDamage = attacker.getDamage();

        if(attackType.equals("Fire")){
            if(deffenseType.equals("Water")){
                return baseDamage / 2;
            }else if(deffenseType.equals("Grass")){
                return baseDamage * 2;
            }
        }else if(attackType.equals("Water")){
            if(deffenseType.equals("Fire")){
                return baseDamage * 2;
            }else if(deffenseType.equals("Grass")){
                return baseDamage / 2;
            }
        }else if(attackType.equals("Grass")){
            if(deffenseType.equals("Fire")){
                return baseDamage / 2;
            }else if(deffenseType.equals("Water")){
                return baseDamage * 2;
            }
        }
        return baseDamage;
    }
}