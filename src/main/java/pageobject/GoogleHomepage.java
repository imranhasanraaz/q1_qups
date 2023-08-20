package pageobject;

import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ITextBox;
import framework.BaseForm;
import org.openqa.selenium.By;

public class GoogleHomepage extends BaseForm {
    private final ITextBox searchBox = getElementFactory().getTextBox(By.xpath("//textarea[@class='gLFyf']"), "Search Box");
    private final IElement searchSuggestionBox = getElementFactory().getLabel(By.xpath("//div[@class='erkvQe']"), " Search suggestions");

    public GoogleHomepage() {
        super(By.xpath("//img[@class='lnXdpd']"), "Google homepage logo");
    }

    public void SearchKeyword(String keyword) {
        searchBox.clearAndType(keyword);
    }

    public String getSearchResultSuggestions() {
        return searchSuggestionBox.getText();
    }
}