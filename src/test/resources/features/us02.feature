Feature:Giriş sayfasında bulunan ülkelerin testi

  Background: Kullanıcı her test için aynı sayfayı açacaktır
    Given Kullanıcı "https://www.waa2.com" açar

  @tc01
  Scenario: Kullanıcı sırayla ülkelere tıklayarak ülkeye ait URLe gittiğini görmelidir
    When Anasayfada bulunan ülkerelere sırayla tıklanır
    Then Açılan her sayfanın ilgili ülkeye ait olduğu görülür



  @tc02
  Scenario:Her ülkeye ait homes sayfaları için sale ve rent altında property type ve city değerleri görülmelidir
    When Anasayfada bulunan ülkereler sırayla tıklanır
    Then Satılık tagı altında property_type ve city değerlerinin olduğu görülür
    When Kiralık opsiyonu tıklanır
    Then Kiralık tagı altında property_type ve city değerlerinin olduğu görülür