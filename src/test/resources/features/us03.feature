Feature: Sosyal Medya ve Hakkında bölümünün testi


  Background: Kullanıcı her test için aynı sayfayı açacaktır
    Given Kullanıcı "https://www.waa2.com" açar

    @tc01
  Scenario: Add Your Listing sekmesinin düzgün çalıştığı görülmelidir
    Then Kullanıcı add your listinge tıkladıgında Get listed on Waa2 yazısı görülmelidir
    Then Home için Learn More tıkladığında Homes yazısı görülmelidir
    Then Homes mimarisi için Feed Structure tıkladığında Structure yazısı görülmelidir
    When Get Listed on Waa2 tıklanır
    And  Car için Learn More tıklanır
    Then Açılan sayfada Cars bilgi kısmı görülür
    Then Cars mimarisi için Feed Stracture tıkladığında Structure kısmı görülür
    When Get Listed on Waa2 tıklanır
    And  Boat için Learn More tıklanır
    Then Açılan sayfada Boats bilgi kısmı görülür
    Then Boats mimarisi için Feed Stracture tıklandığında Structure kısmı görülür


    @tc02
    Scenario: Terms of privacy, term of use ve about us sekmelerinin düzgün çalıştığı görülmelidir
      When Sayfa altında bulunan Terms of privacy tıklanır
      Then Waa2 Privacy Policy görülür
      When Sayfa altında bulunan Terms of use tıklanır
      Then Waa2 Terms Of Use görülür
      When About us tıklanır
      Then Our Mission görülür


    @tc03
    Scenario Outline: LinkedIn,Facebook,Twitter ve Instagram sayfa linklerinin düzgün çalıştığı görülmelidir
      When "<Test edilecek ikon>" tıklanır
      Then Açılan sayfanın "<açılan sayfa>" olduğu görülür

      Examples:
        | Test edilecek ikon | açılan sayfa |
        | linkedin | linkedin.com |
        | facebook | facebook.com |
        | twitter | twitter.com |
        | instagram | instagram.com |


