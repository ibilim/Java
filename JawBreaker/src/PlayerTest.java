import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player=new Player("schenker",new Location(Counties.Bronx));
    Event buyCandy=new BuyCandy("Buy Candy", Duration.ZERO);
    @Test

    @DisplayName("Test Total")
    void getTotalCandies() {
        buyCandy.process(player,new Candy(Candytype.Snickers,1));
        buyCandy.process(player,new Candy(Candytype.Kinderei,5));
//        buyCandy.process(player,new Candy(Candytype.Allpella,5));
//        buyCandy.process(player,new Candy(Candytype.Nutella,5));
        assertEquals(6,player.getTotalCandies());

    }
    @DisplayName("compare references")
    @Test //verglich refrnze typen. wir bekommen fehler meldung weil beide spielern gleich sind.
    void compare_objects() {
        Player  player1=player;
        assertSame(player1,player,"Both players should be same");
    }

    @DisplayName("Test Location")
    @Test
    void moveTo() {
        Location location=player.getLocation();
        player.moveTo(new Location(Counties.Manhattan));
        assertFalse(location.equals(player.getLocation()));
        assertFalse(location==player.getLocation());
    }

    @Test
    void getPlayerName() {
    }

    @Test
    void setPlayerName() {
    }

    @DisplayName("Test Robbery")
    @Test
    void getCandies() {
        Event robbery=new Robbery("Got robbed",Duration.ZERO);
        robbery.process(player,null);
        assertNull(player.getCandies());

    }

    @Test
    void setCandies() {
    }

    @Test
    void getLocation() {
    }

    @Test
    void setLocation() {
    }

    @Test
    void getCash() {
    }

    @Test
    void setCash() {
    }

    @Test
    void getDebt() {
    }

    @Test
    void setDebt() {
    }

//    @Test
//    @EnabledOnOs(MAC)
//    void onlyOnMacOs() {
//        // ...
//    }
//
//    @TestOnMac
//    void testOnMac() {
//        // ...
//    }
//
//    @Test
//    @EnabledOnOs({ LINUX, MAC })
//    void onLinuxOrMac() {
//        // ...
//    }
//
//    @Test
//    @DisabledOnOs(WINDOWS)
//    void notOnWindows() {
//        // ...
//    }
//
//    @Test
//    @EnabledOnJre(JAVA_8)
//    void onlyOnJava8() {
//        // ...
//    }
//
//    @Test
//    @EnabledOnJre({ JAVA_9, JAVA_10 })
//    void onJava9Or10() {
//        // ...
//    }
//
//    @Test
//    @EnabledForJreRange(min = JAVA_9, max = JAVA_11)
//    void fromJava9to11() {
//        // ...
//    }
//
//    @Test
//    @EnabledForJreRange(min = JAVA_9)
//    void fromJava9toCurrentJavaFeatureNumber() {
//        // ...
//    }
//
//    @Test
//    @EnabledForJreRange(max = JAVA_11)
//    void fromJava8To11() {
//        // ...
//    }
//
//    @Test
//    @DisabledOnJre(JAVA_9)
//    void notOnJava9() {
//        // ...
//    }
//
//    @Test
//    @DisabledForJreRange(min = JAVA_9, max = JAVA_11)
//    void notFromJava9to11() {
//        // ...
//    }
//
//    @Test
//    @DisabledForJreRange(min = JAVA_9)
//    void notFromJava9toCurrentJavaFeatureNumber() {
//        // ...
//    }
//
//    @Test
//    @DisabledForJreRange(max = JAVA_11)
//    void notFromJava8to11() {
//        // ...
//    }
//
//    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
//    void onlyOn64BitArchitectures() {
//        // ...
//    }


}