Feature: Homes-Arama fonksiyonlarının testi


  Background: Kullanıcı her test için aynı sayfayı açacaktır
    Given Kullanıcı "https://www.waa2.com" açar

  @tc01
  Scenario: Kullanıcı for-sale kısmından property_type ve city seçtiğinde arama sonucunun aranan kriterlerle eşleştiğini görmelidir
    When Homes butonu tıklanır
    And Property type seçilir "townhouse"
    And City seçilir "colorado"
    Then Arama sonucunda search barda property type + city keywordü görülür
    Then Arama sonucunda ilanların listelendiği görülür


  @tc02
  Scenario: Kullanıcı for-rent kısmından property_type ve city seçtiğinde arama sonucunun aranan kriterlerle eşleştiğini görmelidir
    When Homes butonu tıklanır
    And Property type seçilir "apartment"
    And City seçilir "kansas"
    Then Arama sonucunda search barda property type + city keywordü görülür
    Then Arama sonucunda ilanların listelendiği görülür

  @tc03
  Scenario: Kulanıcı search bar vasıtasıyla arama aksiyonları gerçekleştirebilmelidir.
    When Homes butonu tıklanır
    And Arama çubuğuna keyword yazılır "apartment"
    And Search tıklanır
    Then Arama sonucunda keyword + ilan tipi görülür
    Then Arama sonucunda ilanların listelendiği görülür

  @tc04
  Scenario: Kullanıcı change country kısmından ülke değiştirebilmelidir.
    When Homes tıklanır
    And Change Country kısmından hedef ülke seçilir.index="3"
    Then Açılan sayfa URLnin hedef ülkeye ait olduğu görülür

    #wa
  @tc05
  Scenario: Kullanıcı 3 karakter altı kelime ile arama yapamamalıdır
    When Homes tıklanır
    And Arama çubuğuna minimum karakter sayısı altında keyword yazılır.input="wx"
    Then Uyarı mesajı görülür