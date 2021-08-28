package selenide.whatsonchain;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class Network {

    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);

    @Test
    public void networkMainnet() {

        open("https://whatsonchain.com/");
        $(Selectors.withText("Network")).shouldBe(visible);
        $(Selectors.withText("Network")).click();
        $(Selectors.byXpath(" //span[contains(text(),'Mainnet')]")).click();
        $(Selectors.withText("Mainnet Summary")).shouldBe(visible);
        $(Selectors.withText("Testnet Summary")).shouldNotBe(visible);
        $(Selectors.withText("STN Summary")).shouldNotBe(visible);

        String hashrateDiv = $(Selectors.byXpath("/html[1]/body[1]/div[1]/div[4]/div[2]/div[1]/div[1]/ul[1]/li[1]")).getText();
        assert hashrateDiv.contains("Hashrate");
        assert hashrateDiv.contains("PH/s");

        String transactionDiv = $(Selectors.byXpath("/html[1]/body[1]/div[1]/div[4]/div[2]/div[1]/div[2]/ul[1]/li[1]")).getText();
        assert transactionDiv.contains("Unconfirmed Transactions");
        assert transactionDiv.contains("tx");
        assert transactionDiv.contains("Estimated block size");
        assert transactionDiv.contains("Mempool Usage");

        String difficultyDiv = $(Selectors.byXpath("/html[1]/body[1]/div[1]/div[4]/div[2]/div[1]/div[3]/ul[1]/li[1]")).getText();
        assert difficultyDiv.contains("Difficulty");
        assert difficultyDiv.contains("109");

        String exchangerateDiv = $(Selectors.byXpath("/html[1]/body[1]/div[1]/div[4]/div[2]")).getText();
        assert exchangerateDiv.contains("Exchange Rate");
        assert exchangerateDiv.contains("usd");

        String chainworkDiv = $(Selectors.byXpath("/html[1]/body[1]/div[1]/div[4]/div[2]/div[1]/div[5]/ul[1]/li[1]")).getText();
        assert chainworkDiv.contains("Chainwork");
        assert chainworkDiv.contains("hashes");

        String circulatingsupplyDiv = $(Selectors.byXpath("/html[1]/body[1]/div[1]/div[4]/div[2]/div[1]/div[6]/ul[1]/li[1]")).getText();
        assert circulatingsupplyDiv.contains("Circulating Supply");
        assert circulatingsupplyDiv.contains("BSV");
    }
}
