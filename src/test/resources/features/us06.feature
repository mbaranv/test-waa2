Feature: Cars-Arama fonksiyonlarının testi

  Background: Kullanıcı her test için aynı sayfayı açacaktır
    Given Kullanıcı "https://www.waa2.com" açar

  @tc01
  Scenario: Kulanıcı search bar vasıtasıyla arama aksiyonları gerçekleştirebilmelidir.
    When Cars butonu tıklanır
    And Arama çubuğuna keyword yazılır "toyota"
    And Search tıklanır
    Then Arama sonucunda keyword + ilan tipi görülür
    Then Arama sonucunda ilanların listelendiği görülür

  @tc02
  Scenario Outline: Kullanıcı popular brands kısmından arama aksiyonları gerçekleştirebilmelidir.
    When Cars butonu tıklanır
    And Popular brands kısmından "<make>" değerlerine ait "<model>" seçilir
    Then Arama sonucunda sayfa başında "<make>" "<model>" keywordu görülür
    And Listelenen ilanların title kısmında "<make>" "<model>" verisinin yer aldığı görülür

    Examples:
      | make  | model  |
      | honda | accord |

    @tc03
    Scenario: Kullanıcı 3 karakter altı kelime ile arama yapamamalıdır
      When Cars butonu tıklanır
      And Arama çubuğuna minimum karakter sayısı altında keyword yazılır.input="tr"
      Then Uyarı mesajı görülür