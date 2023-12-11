Feature: Cars-Filtreleme fonksiyonlarının testi

  Background: Kullanıcı her test için aynı sayfayı açacaktır
    Given Kullanıcı "https://www.waa2.com" açar


  @tc01
  Scenario Outline:Kullanıcı arama yaptıktan sonra order by fonksiyonuna göre sıralama yapabilmelidir.

    When Cars butonu tıklanır
    And Arama çubuğuna "<keyword>" yazılır
    And Search tıklanır
    And Publication date today seçilir
    And Order by menüsünden price(cheapest first) seçilir
    Then Arama sonucunda ilanların fiyata göre artan sırada listelendiği görülür

    Examples:
      | keyword       |
      | ford aerostar |


  @tc02
  Scenario Outline:Kullanıcı arama yaptıktan sonra make-model filtresini uygulayabilmelidir.
    When Arama yapılacak "<country>" ve "<vertical>" seçilir
    And Lokasyon kısmına "<keyword>" yazılır
    And Search tıklanır
    And Make değeri için "<make>" seçilir
    And Model değeri için "<model>" seçilir
    Then Listelenen ilanların make ve model kısmında  "<make>" "<model>" verisinin yer aldığı görülür

    Examples:
      | keyword   | country | vertical | make    | model  |
      | stockholm | sweden  | car      | hyundai | tucson |


    #siblings xpath
  @tc03
  Scenario Outline:Kullanıcı arama yaptıktan sonra year filtresini uygulayabilmelidir.
    When Arama yapılacak "<country>" ve "<vertical>" seçilir
    And Arama çubuğuna "<keyword>" yazılır
    And Search tıklanır
    And Year filtresinden "<min year>" ve "<max year>" seçilir
    Then Arama sonucunda çıkan ilanların model yılının "<min year>" "<max year>" aralığında olduğu görülür

    Examples:
      | keyword    | country   | vertical | min year | max year |
      | opel astra | australia | car      | 2021     | 2023     |

    #kia sorento
  @tc04
  Scenario:Kullanıcı arama yaptıktan sonra price min-max filtresini uygulayabilmelidir.
    When Cars butonu tıklanır
    And Arama çubuğuna "honda civic" yazılır
    And Search tıklanır
    And Price kısmında "15000" ve "20000" fiyat seçilir
    Then Filtreleme sonucu ilanların fiyatlarının "15000" ve "20000" aralığında olduğu görülür


  @tc05
  Scenario Outline:Kullanıcı arama yaptıktan sonra mileage filtresini uygulayabilmelidir.
    When Arama yapılacak "<country>" ve "<vertical>" seçilir
    And Arama çubuğuna "<keyword>" yazılır
    And Search tıklanır
    And Mileage kısmında "<minimum>" ve "<maksimum>" değer girilir
    Then Arama sonuçlarının mileage değerine göre "<minimum>" ve "<maksimum>" aralığında olduğu görülür

    Examples:
      | keyword      | country | vertical | minimum | maksimum |
      | renault clio | france  | car      | 40000   | 60000    |

  @tc06
  Scenario Outline:Kullanıcı arama yaptıktan sonra state-city filtresini uygulayabilmelidir.
    When Arama yapılacak "<country>" ve "<vertical>" seçilir
    And Arama çubuğuna "<keyword>" yazılır
    And Search tıklanır
    And State kısmından "<state>" seçilir
    And City kısmından "<city>" seçilir
    Then Filtreleme sonucu ilanların lokasyonunun "<state>" ve "<city>"  şeklinde oluştuğu görülür

    Examples:
      | keyword | country | vertical | state  | city    |
      | audi    | Italia  | car      | milano | magenta |


  @tc07
  Scenario Outline: Kullanıcı çoklu filtre uygulayabilmelidir.
    When Arama yapılacak "<country>" ve "<vertical>" seçilir
    And Arama çubuğuna "<keyword>" yazılır
    And Search tıklanır
    And Model değeri için "<model>" seçilir
    And Transmission "<transmission>" seçilir
    And Type of fuel "<fuel>" seçilir
    Then Listelenen ilanların make ve model kısmında  "<model>" "" verisinin yer aldığı görülür
    And Listelenen ilanların "<transmission>" ve "<fuel>" bilgilerinin seçilen değerler ile eşdeğer olduğu görülür

    Examples:
      | keyword | country        | vertical | model | transmission | fuel     |
      | peugeot | united kingdom | car      | 2008  | auto         | electric |




