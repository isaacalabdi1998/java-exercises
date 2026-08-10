public class EnumExercises
{

  
    enum Season
    {
        SPRING("Flowers bloom"),
        SUMMER("Sun shines"),
        AUTUMN("Leaves fall"),
        WINTER("Snow falls");

        private final String description;

        Season(String description)
        {
            this.description = description;
        }

        public String getDescription()
        {
            return description;
        }
    }


  
    enum Priority
    {
      
        LOW(1),
        MEDIUM(2),
        HIGH(3);

        private final int level;

        Priority (int level)
        {
            this.level = level;
        }

        public int getLevel()
        {
            return level;
        }
      
    }




    ///  ------------------------- Main Method -------------------------
    public static void main(String[] args)
    {
        System.out.println("=== Season Switch ===");
        Season season = Season.SUMMER;


        switch (season)
        {
            case SPRING:
                System.out.println("Spring: " + season.getDescription());
                break;

            case SUMMER:
                System.out.println("Summer: " + season.getDescription());
                break;

            case AUTUMN:
                System.out.println("Autumn: " + season.getDescription());
                break;

            case WINTER:
                System.out.println("Winter: " + season.getDescription());
                break;
        }


      
        System.out.println("\n=== Iterate Over Enum Values ===");
        for (Season s : Season.values())
        {
            System.out.println(s.ordinal() + ": " + s + " - " + s.getDescription()
            );
        }

        System.out.println("\n=== Priority Values ===");

        for (Priority priority : Priority.values())
        {
            System.out.println(priority + " - Level: " + priority.getLevel());
        }

    }
    
}
