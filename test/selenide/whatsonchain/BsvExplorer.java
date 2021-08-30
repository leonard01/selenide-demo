package selenide.whatsonchain;

import com.codeborne.selenide.*;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.selector.ByAttribute;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.CollectionCondition;

public class BsvExplorer {

    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);

    @Test
    public void header() {

        open("https://whatsonchain.com/");

        $(By.className("h3")).shouldBe(visible).shouldHave(
                visible.text("BSV Explorer")
        );

    }

    @Test
    public void labelContainers() {

        open("https://whatsonchain.com/");

        $(By.id("woc-header-graph")).shouldBe(visible);
        $(By.id("woc-header-graph")).find(By.className("label-container")).shouldBe(visible);
        int numberOfContainers = $(By.id("woc-header-graph")).$$(".label-container").size();
        assert numberOfContainers == 12;
        $(By.cssSelector("a[target='_blank']"),1).shouldBe(visible).shouldHave(
                visible.text("#702630")
        );

        $(By.cssSelector("a[target='_blank']"),2).shouldBe(visible).shouldHave(
                visible.text("#702629")
        );
    }

}
