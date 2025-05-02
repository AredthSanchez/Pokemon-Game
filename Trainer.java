public class Trainer{
    private String name;
    private int level;
    private boolean pokemonChampion;
    private Pokemon partner;
    private Pokemon[] team;
    private int teamCount;
    private String[] badges;
    private int badgeCount;

    public Trainer(String name, int level){
        this.name = name;
        this.level = level;
        this.pokemonChampion = false;
        this.partner = null;
        this.team = new Pokemon[6];
        this.teamCount = 0;
        this.badges = new String[5];
        this.badgeCount = 0;
    }
    public Trainer(String name, Pokemon[] pokemonTeam, String[] badges, boolean pokemonChampion){
        this.name = name;
        this.team = pokemonTeam;
        this.teamCount = pokemonTeam.length;
        this.badges = badges;
        this.badgeCount = badges.length;
        this.pokemonChampion = pokemonChampion;
        this.partner = null;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public boolean isPokemonChampion(){
        return pokemonChampion;
    }
    public void setPokemonChampion(boolean status){
        this.pokemonChampion = status;
    }
    public Pokemon getPartner(){
        return partner;
    }
    public void setPartner(Pokemon pokemon){
        this.partner = pokemon;
    }
    public boolean addPokemon(Pokemon pokemon){
        if(teamCount < 6){
            team[teamCount] = pokemon;
            teamCount++;
            return true;
        }
        return false;
    }
    public boolean removePokemon(String pokemonName){
        for(int i = 0; i < teamCount; i++){
            if(team[i].getName().equals(pokemonName)){
                for(int j = i; j < teamCount - 1; j++){
                    team[j] = team[j + 1];
                }
                team[teamCount - 1] = null;
                teamCount--;
                return true;
            }
        }
        return false;
    }
    public void trainPokemon(){
        if(partner != null){
            partner.setLevel(partner.getLevel() + 1);
            System.out.println(partner.getName() + " is now level " + partner.getLevel() + "!");
        }else{
            System.out.println("No partner Pokemon to train!");
        }
    }
    public Pokemon[] getTeam(){
        return team;
    }
    public int getTeamCount(){
        return teamCount;
    }
    public String[] getBadges(){
        return badges;
    }
    public void setBadges(String[] badges){
        this.badges = badges;
        this.badgeCount = badges.length;
    }
    public void getDetails(){
        System.out.println("Trainer Name: " + name);
        System.out.print("Badges: ");
        int i = 0;
        while(i < badgeCount){
            System.out.print(badges[i]);
            if(i < badgeCount - 1){
                System.out.print(", ");
            }
            i += 1;
        }
        System.out.println();
        System.out.println("Champion: " + pokemonChampion);
        System.out.print("Team: ");
        i = 0;
        while(i < teamCount){
            System.out.print(team[i].getName());
            if(i < teamCount - 1){
                System.out.print(", ");
            }
            i += 1;
        }
        System.out.println();
        if(partner != null){
            System.out.println("Partner:");
            partner.getDetails();
        }
    }
    public void choosePartner(String name){
        boolean found = false;
        int i = 0;
        while(i < teamCount && !found){
            if(team[i] != null && team[i].getName().equals(name)){
                partner = team[i];
                found = true;
            }else{
                i += 1;
            }
        }
        if(found){
            System.out.println(name + " is now your partner!");
        }else{
            System.out.println("Pokemon not found in team. Cannot set as partner.");
        }
    }
}