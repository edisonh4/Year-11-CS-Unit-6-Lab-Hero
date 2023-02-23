public class Hero {
    //properties
    private String name;
    private int hitPoints;
    //constructors
    public Hero(String name){
        this.name = name;
        hitPoints=100;
    }
    public String getName(){
        return name;
    }
    public int getHitPoints(){
        return hitPoints;
    }
    public String toString(){
        return "Hero{name='" + name + "', hitPoints=" + hitPoints+"}";
    }
    public void attack(Hero opponent){
        double damage = Math.random();
        if (damage>0.5){
            hitPoints = hitPoints - 10;
        }
        else{
            opponent.hitPoints-=10;
        }
    }
    public void senzuBean(){
        hitPoints = 100;
    }
    private void fightUntilTheDeathHelper(Hero opponent){
        while (opponent.hitPoints>0&&hitPoints>0){
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent){
        fightUntilTheDeathHelper(opponent);
        return (name + ": " + hitPoints + " " + opponent.name + ": " + opponent.hitPoints);
    }
    private int[] nFightsToTheDeathHelper(Hero opponent, int numberOfFights){
        int[] count = new int[2];
        while (numberOfFights>0){
            fightUntilTheDeath(opponent);
            if (hitPoints == 0 && opponent.hitPoints==0){
                if (hitPoints==0) {
                    count[1]++;
                }else
                    count[0]++;
                senzuBean();
                opponent.senzuBean();
            }
            numberOfFights=numberOfFights-1;
        }
        return count;
    }
    public String nFightsToTheDeath(Hero opponent, int numberOfFights){
        int[] count = nFightsToTheDeathHelper(opponent, numberOfFights);
        String output = (name + ": " + count[0] + " wins" + opponent.name + ": " + count[1] + " wins");
        if (count[0] == count[1]){
            return name + ": " + count[0] + " wins\n" + opponent.name + ": " + count[1] + " wins\n" + "OMG! It was actually a draw!";
        }else if(count[0]<count[1]){
            return name + ": " + count[0] + " wins\n" + opponent.name + ": " + count[1] + " wins\n" + opponent.name + " wins!";
        } else{
            return name + ": " + count[0] + " wins\n" + opponent.name + ": " + count[1] + " wins\n" + name + " wins!";
    }}

        public void dramaticFightToTheDeath(Hero opponent){
            while(opponent.hitPoints != 0 || hitPoints != 0){
                attack(opponent);
                System.out.println(name + ": " + hitPoints + "\t" + opponent.name + ": " + opponent.hitPoints);
            }

            if(opponent.hitPoints == 0){
                System.out.println(name + " wins!");
            }

            if(hitPoints == 0){
                System.out.println(opponent.name + " wins!");
            }
        }
}
