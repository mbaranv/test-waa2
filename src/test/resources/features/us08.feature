Feature: Boats-Arama fonksiyonlarının testi

  Background: Kullanıcı her test için aynı sayfayı açacaktır
    Given Kullanıcı "https://www.waa2.com" açar

  @tc01
  Scenario: Kulanıcı search bar vasıtasıyla arama aksiyonları gerçekleştirebilmelidir.
    When Boats butonu tıklanır
    And Arama çubuğuna keyword yazılır "yacht"
    And Search tıklanır
    Then Arama sonucunda keyword + ilan tipi görülür
    Then Arama sonucunda ilanların listelendiği görülür
    And Listelenen ilanların title kısmında "yacht" "" verisinin yer aldığı görülür


  @tc02
  Scenario: Kullanıcı sailboat bölümünden arama aksiyonları gerçekleştirebilmelidir.
    When Boats butonu tıklanır
    And Sailboat olarak "hallberg-rassy" seçilir
    Then Arama sonucunda sayfada seçilen "hallberg-rassy" ismi görülür
    And Listelenen ilanların title kısmında "hallberg-rassy" "" verisinin yer aldığı görülür

  @tc03 #iframe
  Scenario: Kullanıcı powerboat bölümünden arama aksiyonları gerçekleştirebilmelidir.
    When Boats butonu tıklanır
    And Powerboat olarak "cobalt" seçilir
    Then Arama sonucunda sayfada seçilen "cobalt" ismi görülür
    And Listelenen ilanların title kısmında "cobalt" "" verisinin yer aldığı görülür

  @tc04
  Scenario: Kullanıcı 3 karakter altı kelime ile arama yapamamalıdır
    When Cars butonu tıklanır
    And Arama çubuğuna minimum karakter sayısı altında keyword yazılır.input="bo"
    Then Uyarı mesajı görülür