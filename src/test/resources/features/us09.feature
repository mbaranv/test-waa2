Feature: Boats-Filtreleme fonksiyonlarının testi

  Background: Kullanıcı her test için aynı sayfayı açacaktır
    Given Kullanıcı "https://www.waa2.com" açar

  @tc01
  Scenario Outline: Kullanıcı arama yaptıktan sonra make-model filtresini uygulayabilmelidir.
    When Boats butonu tıklanır
    And Arama çubuğuna keyword yazılır "<keyword>"
    And Search tıklanır
    And Make değeri için "<make>" seçilir
    And Model değeri için "<model>" seçilir
    Then Arama sonuçlarında ilanların title kısmının "<make>" "<model>" içerdiği görülür

    Examples:

      | keyword | make   | model |
      | cruise  | yamaha | 212x  |


  @tc02
  Scenario Outline: Kullanıcı arama yaptıktan sonra price min-max filtresini uygulayabilmelidir.
    When Boats butonu tıklanır
    And Arama çubuğuna "<keyword>" yazılır
    And Search tıklanır
    And Price kısmında "<minimum price>" ve "<maksimum price>" fiyat seçilir
    And Filtreleme sonucu ilanların fiyatlarının "<minimum price>" ve "<maksimum price>" aralığında olduğu görülür

    Examples:
      | keyword | minimum price | maksimum price |
      | cruise  | 800000        | 1100000        |

  @tc03
  Scenario Outline: Kullanıcı arama yaptıktan sonra country filtresini uygulayabilmelidir.
    When Boats butonu tıklanır
    And Arama çubuğuna "<keyword>" yazılır
    And Search tıklanır
    And Country kısmından "<country>" seçilir
    Then Seçilen "<country>" nin yanında yazan sayı ile çıkan arama sonucu sayısı karşılaştırılır
    And Arama sonucunda çıkan ilanların seçilen "<country>" bilgisini içerdiği görülür

    Examples:

      | keyword | country |
      | yacht   | greece  |

    #3.ilan material içermiyor
  @tc04
  Scenario Outline: Kullanıcı çoklu filtre uygulayabilmelidir.
    When Boats butonu tıklanır
    And Arama çubuğuna keyword yazılır "<keyword>"
    And Search tıklanır
    And Country kısmından "<country>" seçilir
    And Hull Material kısmından "<material>" seçilir
    And Price kısmında "<minimum price>" ve "<maksimum price>" fiyat seçilir
    And Length kısmından "<minimum length>" "<maksimum length>" değerler seçilir
    And Order by menüsünden lower price seçilir
    Then Arama sonucunda ilanların fiyata göre artan sırada listelendiği görülür
    And Arama sonucunda çıkan ilanların seçilen "<country>" "<material>" bilgisini içerdiği görülür
    And Arama sonuçlarının "<minimum length>" ve "<maksimum length>" length değerine göre filtrelendiği görülür

    Examples:

      | keyword | country   | material   | minimum length | maksimum length | minimum price | maksimum price |
      | motor   | australia | aluminum | 15             | 70              | 5000          | 900000         |


