Feature: Anasayfa ve kategorilerin testi

  @tc01
  Scenario: Kullanıcı anasayfadaki homes,cars,boats sayfalarını açabilmelidir.
    Given Kullanıcı "https://www.waa2.com" açtığında sayfadaki logo ve title görünür olmalıdır
    Then Homes cars ve boats linkleri tıklanır ve çalıştığı kontrol edilir

