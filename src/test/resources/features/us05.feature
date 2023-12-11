Feature: Homes-Filtreleme fonksiyonlarının testi

  Background: Kullanıcı her test için aynı sayfayı açacaktır
    Given Kullanıcı "https://www.waa2.com" açar

  @tc01
  Scenario Outline: Kullanıcı arama yaptıktan sonra order by fonksiyonuna göre sıralama yapabilmelidir.
    When Homes tıklanır
    And Arama çubuğuna "<keyword>" yazılır
    And Search tıklanır
    And Publication date today seçilir
    And Order by menüsünden sq ft(largest first) seçilir
    Then Arama sonuçlarının alan verisine göre azalan sırada listelendiği görülür

    Examples:
      | keyword |
      | home  |

  @tc02
  Scenario Outline: Kullanıcı arama yaptıktan sonra publication date filtresini uygulayabilmedilir.
    When Homes tıklanır
    And Arama çubuğuna "<keyword>" yazılır
    And Search tıklanır
    And Publication date today seçilir
    When Arama sonuçlarının tarihe göre filtrelendiği görülür

    Examples:
      | keyword |
      | office  |

  @tc03
  Scenario Outline:Kullanıcı arama yaptıktan sonra property type filtresini uygulayabilmelidir.
    When Homes tıklanır
    And Lokasyon kısmına "<keyword>" yazılır
    And Search tıklanır
    And Filtre kısmından "<property type>" seçilir
    Then Arama sonuçlarının "<property type>" göre filtrelendiği görülür
    Then Çıkan sonuç sayısının filtre kısmında yazan sayıyla eşleştiği görülür

    Examples:
      | keyword | property type |
      | texas   | residential   |


  @tc04
  Scenario Outline: Kullanıcı arama yaptıktan sonra price min-max filtresini uygulayabilmelidir.
    When Homes tıklanır
    And Arama çubuğuna "<keyword>" yazılır
    And Search tıklanır
    And Price kısmında "<minimum price>" ve "<maksimum price>" fiyat seçilir
    And Filtreleme sonucu ilanların fiyatlarının "<minimum price>" ve "<maksimum price>" aralığında olduğu görülür

    Examples:
      | keyword | minimum price | maksimum price |
      | land    | 450000        | 450000         |


  @tc05
  Scenario Outline: Kullanıcı arama yaptıktan sonra state-city filtresini uygulayabilmelidir.
    When Homes tıklanır
    And Arama çubuğuna "<keyword>" yazılır
    And Search tıklanır
    And State kısmından "<state>" seçilir
    And City kısmından "<city>" seçilir
    Then Filtreleme sonucu ilanların lokasyonunun "<state>" ve "<city>"  şeklinde oluştuğu görülür

    Examples:
      | keyword | state    | city   |
      | house   | michigan | dallas |


  @tc06
  Scenario Outline: Kullanıcı alan filtresini uygulayabilmelidir.
    When Homes tıklanır
    And Arama çubuğuna "<keyword>" yazılır
    And Search tıklanır
    And Metrekare kısmında "<minimum m2>" ve "<maksimum m2>" değerler seçilir
    Then Arama sonuçlarının "<minimum m2>" ve "<maksimum m2>" değerine göre filtrelendiği görülür

    Examples:
      | keyword | minimum m2 | maksimum m2 |
      | florida | 30         | 60          |


  @tc07
  Scenario Outline: Kullanıcı room-bathroom filtresini kullanabilmelidir.
    When Homes tıklanır
    And Arama çubuğuna "<keyword>" yazılır
    And Search tıklanır
    And Oda kısmından "<room>" ve "<bathroom>" değerler seçilir
    Then Arama sonuçlarının "<room>" ve "<bathroom>" sayısına göre filtrelendiği görülür

    Examples:
      | keyword  | room | bathroom |
      | nebraska | 4    | 2        |

    #fiyat seçildikten sonra state de seçim kalkıyor
  @tc08
  Scenario Outline: Kullanıcı çoklu filtre uygulayabilmelidir.
    When Homes tıklanır
    And Lokasyon kısmına "<keyword>" yazılır
    And Search tıklanır
    And Filtre kısmından "<property type>" seçilir
    And City kısmından "<city>" seçilir
    And Price kısmında "<minimum price>" ve "<maksimum price>" fiyat seçilir
    Then Filtre bölümünde "<state>" ve "<city>" opsiyonunun seçili olduğu görülür
    And Filtre bölümünde property type olarak seçilen "<property type>" opsiyonunun seçili olduğu görülür
    And Filtreleme sonucu ilanların fiyatlarının "<minimum price>" ve "<maksimum price>" aralığında olduğu görülür
    And Filtreleme sonucu ilanların lokasyonunun "<state>" ve "<city>"  şeklinde oluştuğu görülür


    Examples:
      | keyword | minimum price | maksimum price | property type | state   | city  |
      | florida | 300000        | 400000         | condo         | florida | miami |





