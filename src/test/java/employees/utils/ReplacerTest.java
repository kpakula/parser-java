package employees.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReplacerTest {
    private String expected = "5.0";

    private String commaOption = "5,0";
    private String quotationMarkOption ="5.0\"";
    private String emptyOption = " 5.0";


    private String emptyAndQuotationMarkOption = " 5.0\"";
    private String emptyAndCommaOption = " 5,0";
    private String quotationMarkAndCommaOption = "5,0\"";

    private String emptyAndQuotationMarkAndCommaOption = " 5,0\"";


    @Test
    public void shouldBeSameWithReplacedEmptyAndComma() {
        String replaced = Replacer.replaceUnwantedSigns(emptyAndCommaOption);

        Assertions.assertEquals(expected, replaced);
    }


    @Test
    public void shouldBeSameWithReplacedEmptyAndQuotationMarkAndComma() {
        String replaced = Replacer.replaceUnwantedSigns(emptyAndQuotationMarkAndCommaOption);

        Assertions.assertEquals(expected, replaced);
    }

    @Test
    public void shouldBeSameWithReplacedQuotationMarkAndComma() {
        String replaced = Replacer.replaceUnwantedSigns(quotationMarkAndCommaOption);

        Assertions.assertEquals(expected, replaced);
    }

    @Test
    public void shouldBeSameWithReplacedEmpty() {
        String replaced = Replacer.replaceUnwantedSigns(emptyOption);

        Assertions.assertEquals(expected, replaced);
    }

    @Test
    public void shouldBeSameWithReplacedEmptyAndQuotationMark() {
        String replaced = Replacer.replaceUnwantedSigns(emptyAndQuotationMarkOption);

        Assertions.assertEquals(expected, replaced);
    }

    @Test
    public void shouldBeSameWithReplacedComma() {
        String replaced = Replacer.replaceUnwantedSigns(commaOption);

        Assertions.assertEquals(expected, replaced);
    }

    @Test
    public void shouldBeSameWithReplacedQuotationMark() {
        String replaced = Replacer.replaceUnwantedSigns(quotationMarkOption);

        Assertions.assertEquals(expected, replaced);
    }
}
