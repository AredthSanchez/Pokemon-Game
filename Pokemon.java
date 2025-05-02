public class Pokemon{
    private String pokemonName;
    private String pokemonType;
    private int pokemonLevel;
    private int pokemonHealth;
    private int attackDamage;

    // Constructors
    public Pokemon(String nameIn, String typeIn){
        this.pokemonName = nameIn;
        this.pokemonType = typeIn;
    }

    public Pokemon(String nameIn, String typeIn, int levelIn, int healthIn, int attackDamageIn){
        this.pokemonName = nameIn;
        this.pokemonType = typeIn;
        this.pokemonLevel = levelIn;
        this.pokemonHealth = healthIn;
        this.attackDamage = attackDamageIn;
    }

    // Setters and getters
    public void setName(String nameIn){
        this.pokemonName = nameIn;
    }

    public void setType(String typeIn){
        this.pokemonType = typeIn;
    }

    public void setLevel(int levelIn){
        this.pokemonLevel = levelIn;
    }

    public void setHealth(int healthIn){
        this.pokemonHealth = healthIn;
    }

    public void setDamage(int damageIn){
        this.attackDamage = damageIn;
    }
    public String getName(){
        return this.pokemonName;
    }

    public String getType(){
        return this.pokemonType;
    }

    public int getLevel(){
        return this.pokemonLevel;
    }

    public int getHealth(){
        return this.pokemonHealth;
    }

    public int getDamage(){
        return this.attackDamage;
    }

    // Methods
    public void levelUp(){
        this.pokemonLevel += 1;
        this.pokemonHealth += 14;
        this.attackDamage += 1;
    }
    public void speak(){
        System.out.println(pokemonName + "! " + pokemonName + "!");
    }
    public void getDetails(){
        System.out.println("Pokemon Name: " + pokemonName);
        System.out.println("Pokemon Type: " + pokemonType);
        System.out.println("Pokemon Health: " + pokemonHealth);
        System.out.println("Pokemon Level: " + pokemonLevel);
        System.out.println("Pokemon attack damage: " + attackDamage);
    }
}