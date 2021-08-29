package selenide.whatsonchain;

import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Search {

    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);

    @Test
    public void search() {

        open("https://whatsonchain.com/");
        $(By.name("query")).val("10").pressEnter();

        $(By.className("h3")).shouldBe(visible).shouldHave(
                visible.text("Block"),
                visible.text("#10"),
                visible.text("000000002c05cc2e78923c34df87fd108b22221ac6076c18f3ade378a4d915e9")
        );

        $(By.className("h6")).shouldBe(visible).shouldHave(
                visible.text("Summary")
        );

        $(By.className("card-body")).shouldBe(visible).shouldHave(
                visible.text("Previous Block"),
                visible.text("000000008d9dc510f23c2657fc4f67bea30078cc05a90eb89e84cc475c080805\n" +
                        "(#9)"),
                visible.text("Next Block"),
                visible.text("0000000097be56d606cdd9c54b04d4747e957d3608abe69198c661f2add73073\n" +
                        "(#11)"),
                visible.text("Timestamp (utc)"),
                visible.text("Transactions"),
                visible.text("Total Fees"),
                visible.text("Size"),
                visible.text("Confirmations"),
                visible.text("Difficulty"),
                visible.text("1 x 10"),
                visible.text("Nonce"),
                visible.text("Bits"),
                visible.text("Merkle Root"),
                visible.text("Chainwork"),
                visible.text("Miner")
        );

    }
}
