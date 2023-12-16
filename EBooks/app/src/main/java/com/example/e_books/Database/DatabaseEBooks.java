package com.example.e_books.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.e_books.Model.Taikhoan;
import com.example.e_books.Model.Truyen;
import com.example.e_books.Model.TruyenYT;

public class DatabaseEBooks extends SQLiteOpenHelper {

 private static final String DATABASE_NAME = "Ebooks.db";
 private static String TABLE_TAIKHOAN = "taikhoan";
 private static String ID_TAI_KHOAN = "idtaikhoan";
 private static String TEN_TAI_KHOAN = "tentaikhoan";
 private static String MAT_KHAU = "matkhau";
 private static String PHAN_QUYEN = "phanquyen";
 private static String EMAIL = "email";
 private static int VERSION = 1;

 private static final String TABLE_TRUYEN = "truyen";
 private static String ID_TRUYEN = "idtruyen";
 private static String TEN_TRUYEN = "tieude";
 private static String NOI_DUNG = "noidung";
 private static String IMAGE = "anh";

 private static final String TABLE_YEUTHICH="truyenyeuthich";
 private static String ID_YEUTHICH="ìdyeuthich";
 private static String TENYEUTHICH = "tenyeuthich";
 private static String NOIDUNGYEUTHICH = "noidungyeuthich";
 private static String IMAGEYEUTHICH = "anhyeuthich";
 private static String ID_TK= "idtaikhoanyeuthich";




 private Context context;

 private String sqlacc = "CREATE TABLE "+ TABLE_TAIKHOAN +" ( "+ID_TAI_KHOAN+" INTEGER PRIMARY KEY AUTOINCREMENT, "
         +TEN_TAI_KHOAN+" TEXT UNIQUE, "
         +MAT_KHAU+" TEXT, "
         +EMAIL+" TEXT, "
         + PHAN_QUYEN+" INTEGER) ";

 private String SQLQuery1 = "CREATE TABLE "+ TABLE_TRUYEN +" ( "+ID_TRUYEN+" integer primary key AUTOINCREMENT, "
         +TEN_TRUYEN+" TEXT UNIQUE, "
         +NOI_DUNG+" TEXT, "
         +IMAGE+" TEXT, "+ID_TAI_KHOAN+" INTEGER , FOREIGN KEY ( "+ ID_TAI_KHOAN +" ) REFERENCES "+
         TABLE_TAIKHOAN+"("+ID_TAI_KHOAN+"))";

 private String SQLtruyenyt =" Create table "+TABLE_YEUTHICH +"("+ID_YEUTHICH+" integer primary key AUTOINCREMENT,"
         +TENYEUTHICH+" TEXT UNIQUE ,"
         +NOIDUNGYEUTHICH+" TEXT , "
         +IMAGEYEUTHICH + " TEXT ,"
         +ID_TAI_KHOAN+ " INTEGER , FOREIGN KEY ("+ID_TAI_KHOAN+") REFERENCES " +
         TABLE_TAIKHOAN+"("+ID_TAI_KHOAN+"))";
 private String SQLQuery2 = "INSERT INTO TaiKhoan VAlUES (null,'admin','admin','admin@gmail.com',2)";
 private String SQLQuery3 = "INSERT INTO TaiKhoan VAlUES (null,'Ran','Ran','Ran@gmail.com',1)";
    private String SQLQuery4 = "INSERT INTO truyen VALUES (null,'ta tại trấn ma ti nuôi ma','Đột nhiên, biến cố xảy ra!Ngay vị trí lưỡi kiếm chui xuống dưới đất, bỗng nhiên chồi lên vô số cánh tay nam nhân trưởng thành bằng dây leo.\n" +
            "\n" +
            "Những dây leo kia giống như xúc tu của bạch tuộc, giương nanh múa vuốt đánh về phía Cố Thanh Phong.Cố Thanh Phong giật mình, theo bản năng giơ kiếm Mộc Vương trong tay lên.Những cây dây leo kia giống như nhìn thấy chủ nhân, lập tức dừng động tác lại.Cố Thanh Phong âm thầm thở phào.\n" +
            "\n" +
            "Hình như hắn hiểu được cách dùng kiếm Mộc Vương, không nhịn được cầm kiếm chỉ vào một tảng đá cao hơn một mét cách đó không xa.Những cây dây leo kia giống như đã nhận được mệnh lệnh, như mãng xà xuất phát bay nhanh quấn quanh tảng đá kia.Chỉ nghe thấy tiếng \"răng rắc răng rắc\" vang lên không ngừng.Đợi khi dây leo tản đi, tảng đá kia đã biến mất không thấy gì nữa, chỉ để lại một đống bột đá vụn.Hai mắt Cố Thanh Phong sáng lên nhìn vào kiếm Mộc Vương trong tay, thầm nghĩ \"Thì ra đây mới là cách dùng đúng của kiếm Mộc Vương.Bảo bối tốt, tranh thủ nhỏ máu nhận chủ nào.\"Cố Thanh Phong dùng kiếm Mộc Vương cứa nhẹ vào ngón tay của mình một cái, nhưng không hề đứt tay, chỉ có một đường trắng nhàn nhạt.Lúc này hắn mới nhớ ra, mình là mình động da sắt Thiết Bố Sam đại thành.\n" +
            "\n" +
            "\n" +
            "Mặc dù kiếm Mộc Vương này là linh binh cấp Huyền nhưng rõ ràng không nổi danh vì sắc bén, độ sắc bén này chỉ có thể so với binh khí thường.Chuyện này có thể khiến cho Cố Thanh Phong nhức đầu.\n" +
            "\n" +
            "Không cắt được tay thì nhỏ máu nhận chủ kiểu gì?Lúc này hình như kiếm Mộc Vương nhận ra phiền não.\n" +
            "\n" +
            "Vậy mà nó mọc ra mấy đầu dây leo nhỏ bé từ lưỡi kiếm, dâo leo như kim đâm mạnh vào cánh tay của hắn.\"Ui da! Mẹ nó! Đau!\" Cố Thanh Phong kêu to một tiếng.Điều này khiến cho hắn không nhịn được nghĩ đến cảm giác chị y tá rút máu lúc kiểm tra sức khoẻ.Khi huyết dịch cơ thể bị rút ra, lập tức có cảm giác huyết mạch tương liên với kiếm Mộc Vương chảy trên người.\n" +
            "\n" +
            "Giờ phút này, Cố Thanh Phong thực sự cảm giác được cái gì gọi là như có cánh tay sai khiến.Kiếm Mộc Vương giống như kéo dài tay chân mình ra.\"Đây chính là Linh binh sao? Quả nhiên có linh tính thật...Ui da mẹ nó! Mẹ nó ngươi còn hút à!\" Cố Thanh Phong chỉ cảm thấy huyết dịch cả người đang không ngừng chảy về phía kiếm Mộc Vương kia.Kiếm Mộc Vương giống như quỷ chết đói đầu thai, điên cuồng hút huyết dịch của Cố Thanh Phong.Không bao lâu sau, Cố Thanh Phong liền cảm thấy đầu váng mắt hoa một trận, hắn vội vàng kêu to: \"Ngừng! Mau ngừng lại, không thì lão tử chôn ngươi xuống tiếp đấy!\"Vừa dứt lời, lúc này kiếm Mộc Vương mới ngừng hút máu.\"Hô!\"Cố Thanh Phong thở ra một ngụm khí thô.\"Mẹ nó! Đúng là tà tính!\"Thật ra Cố Thanh Phong không biết rằng linh binh không hề tuỳ tiện nhận chủ.\n" +
            "\n" +
            "Chủ nhân của linh binh phải có thực lực tương xứng thì mới có thể khống chế linh binh, nếu không trong quá trình nhận chủ sẽ bị linh binh hút chết.Ít nhất thì Linh binh cần một võ giả Nội khí cảnh mới có thể khống chế.\n" +
            "\n" +
            "Trong cơ thể có được nội khí thì mới có thể cung cấp cho Linh binh hấp thu.Cố Thanh Phong là Tụ Khí cảnh, chút nguyên khí trong cơ thể chính là điểm thêm, vậy nên chỉ có thể hút máu.\n" +
            "\n" +
            "Cũng chính vì thể chất của Cố Thanh Phong khác với người thường, có được sức chín trâu hai hổ cộng thêm mình đồng da sắt.\n" +
            "\n" +
            "\n" +
            "Tố chất cơ thể có thể so với võ giả Nội khí cảnh nên lúc này mới chống lại được, không thì lúc này đã trở thành bộ xương khô từ lâu.Cố Thanh Phong mất một lúc lâu mới khôi phục lại.\n" +
            "\n" +
            "Lúc này trong mắt của hắn đầy vẻ mừng rỡ.Bởi vì trong quá trình nhận chủ, hắn đã lấy được một chút tin tức từ kiếm Mộc Vương, liên quan đến năng lực của kiếm Mộc Vương.Kiếm Mộc Vương này không hổ đã từng là linh binh Địa cấp thượng phẩm, năng lực thật mạnh hơn nữa hoa văn còn nhiều.\n" +
            "\n" +
            "Tuy nói bây giờ rớt cấp, hơn một nửa năng lực không thể dùng, uy lực còn giảm xuống nhưng vẫn siêu phàm đứng vị trí Linh binh cấp Huyền hạ phẩm.Mấu chốt là, kiếm Mộc Vương như cây cối bị chém đứt thân cành vẫn có thể tái sinh.\n" +
            "\n" +
            "Chỉ cần cho nó dinh dưỡng cực lớn thì sớm muộn gì nó cũng khôi phục lại thành Địa cấp thượng phẩm!\"Cây hoè yêu vẫn khá đáng tin, quả nhiên không lừa gạt mình.\n" +
            "\n" +
            "\n" +
            "Kiếm Mộc Vương cũng thật lợi hại.\" Cố Thanh Phong nhìn kiếm Mộc Vương vui vẻ nói.\"Để khen thưởng, phải chờ một cơ hội giúp Cây hoè yêu giải thoát vậy.\n" +
            "\n" +
            "Dù sao thì nhốt ở trong Trấn Ma Ngục cũng là chịu tội, không bằng dùng làm chất dinh dưỡng cho kiếm Mộc Vương.\n" +
            "\n" +
            "Lúc trước lão già này hút không ít linh tính của kiếm Mộc Vương, giết lão rồi nhất định có thể khiến kiếm Mộc Vương khôi phục không ít.\"Cố Thanh Phong vui mừng nghĩ.Đáng thương cho cây hoè yêu đầy vui vẻ trong lòng nghĩ là mình cống hiến kiếm Mộc Vương thì có thể tạo được niềm vui cho Cố Thanh Phong, từ đó mà được sống tốt hơn một chút trong Trấn Ma Ngục.Ai mà ngờ được Cố Thanh Phong vừa quay đầu đã muốn qua cầu rút ván.Cố Thanh Phong thu kiếm Mộc Vương lại, chuẩn bị rời khỏi miếu Sơn Thần.Nhưng đúng lúc này, hắn đột nhiên cảm giác đỉnh đầu mát lạnh, ngẩng đầu nhìn lên thì trên mặt cũng lạnh theo, thì ra là trời mưa..','https://static.cdnno.com/poster/ta-tai-tran-ma-ti-nuoi-ma/300.jpg?1659875216',1)";
    private String SQLQuery5 = "INSERT INTO truyen VALUES (null,'thần đạo đan tôn','Huyền Linh Đại Đế tò mò mãnh liệt, Lăng Hàn vận dụng bốn yếu tố mạnh hơn hắn, tối thiểu cũng mạnh hơn hai thành. Đến độ cao của bọn họ, vượt qua hai thành là ưu thế rất lớn. Không thể tưởng tượng nổi. Ngươi dựa vào cái gì? Bành! Huyền Linh Đại Đế đón đỡ một quyền của Lăng Hàn, hắn bị đánh bay đi xa. Lăng Hàn đuổi kịp, song quyền oanh kích.\n" +
            "\n" +
            "Bành bành bành, mỗi một quyền đều rất mạnhcũng nhanh chóng đánh ngực Huyền Linh Đại Đế nứt ra, lộ ra xương trắng và nội tạng. Nhưng mà, Huyền Linh Đại Đế dùng ý niệm quét qua, thương thế của hắn khép lại và không lưu dấu vết gì cả. Lăng Hàn chiếm ưu thế về mặt chiến lực, hơn nữa còn chiếm ưu thế rất lớn, hắn vẫn không thể giết chết Huyền Linh Đại Đế. Hắn muốn thu Huyền Linh Đại Đế vào nội thiên địa của mình, nhưng căn bản không có cách gì làm được. Song phương chiến lực chênh lệch chưa tới mức nghiền ép. – Ngươi đúng là hậu bối kỳ quái! Huyền Linh Đại Đế cảm khái một câu, sau đó sờ cằm.. – Vốn cho rằng, lực lượng của chúng ta đã đạt đến cực hạn, không nghĩ tới còn có thể tăng lên. – Không bồi ngươi chơi, bản đế muốn bế quan tìm hiểu một chút. Bế quan, đây là danh từ xa xôi với hắn, từ khi hắn tu thành bốn yếu tố, hắn đã vô địch thiên hạ, bất tử bất diệt, còn muốn bế quan làm cái gì? Thiên địa hủy diệt cũng không thể giết hắn.\n" +
            "\n" +
            "Nhưng có thể trở thành Đại Đế, có người nào không có tâm vô địch? Hiện tại, lại có người có chiến lực vượt qua hắn, dù hắn vẫn bất tử bất diệt như cũ, nhưng trong lòng rất khó chịu, càng có hùng tâm. Người khác có thể, vì cái gì hắn không thể? Đại Đế cấp thứ nhất chỉ có bốn người bọn họ. Huyền Linh Đại Đế vô cùng dứt khoát, nói không đánh là không đánh, hắn quay người rời đi. Lăng Hàn đồng thời không có truy kích, bởi vì đuổi kịp thì như thế nào, hắn không có cách gì thu đối phương vào nội thiên địa, cũng không thể trấn áp đối phương. Một khi khai chiến ở bên ngoài, lúc đó tạo thành sinh linh đồ thán lớn cỡ nào? Lăng Hàn khác với ba Đại Đế vô địch kia, hắn còn có trái tim lương thiện. Đây không phải lòng dạ đàn bà, nếu như có một ngày Lăng Hàn có thực lực trấn áp ba Đại Đế, như vậy cho dù nhất định khai chiến ở bên ngoài, hắn cũng không tiếc một trận chiến.\n" +
            "\n" +
            "Không phá thì không xây được, chỉ có giải quyết ba Đại Đế, thế gian mới phát triển tự nhiên, mà không phải bị bọn họ can thiệp, thế giới biến thành đồ chơi. Lăng Hàn suy nghĩ, nếu nội thiên địa của hắn ngang hàng với thiên địa này, hắn có thể trấn áp ba người này không? Trong lòng của hắn không suy nghĩ, bởi vì chiến lực như vậy chưa từng có ai đạt tới, tự nhiên chỉ là suy nghĩ viễn vông. Huyền Linh Đại Đế nói bế quan thì bế quan, hắn cũng không quan tâm tới hôn lễ, hắn cũng ném mấy vạn đứa con sang một bên không quan tâm tới. Không có vị Đại Đế này tọa trấn, địa bàn của hắn liền bị Lăng Hàn cùng Vô Lượng Đại Đế phân chia. Lăng Hàn trùng kiến trật tự, mà Vô Lượng Đại Đế tiếp tục phá hư trật tự, tôn sùng bạo lực. Vài vạn năm sau, biên giới hai thế lực lớn đã xen kẽ với nhau, khó tránh khỏi phát sinh xung đột. Nhưng Vô Lượng Đại Đế từ trước đến nay đều không xuất thủ. Hắn thấy, tranh bá gì đó chỉ là trò cười, hắn là người cầm cờ, hắn cần tự mình tham dự chiến đấu hay sao?\n" +
            "\n" +
            "Thắng cũng tốt, thua cũng được, trò vui mà thôi, cùng lắm thì chờ điệp kỷ kế tiếp chơi nữa. Lăng Hàn thì khác. Vô Nhai Đại Đế không có nhiều Đại Đế như Lăng Hàn sáng tạo ra, cho nên Lăng Hàn đường quét ngang, thống trị tinh cầu càng ngày càng nhiều. Vô Lượng Đại Đế có thể sáng tạo ra Đại Đế, nhưng thứ nhất chỉ là cấp thứ tám, thứ hai số lượng chỉ có chín người. Trăm vạn năm qua đi, địa bàn của Vô Lượng Đại Đế đã thu nhỏ còn một phần mười ban đầu, chỉ chiếm năm phần trăm trên toàn vũ trụ. Các Đại Đế liên tiếp xuất thủ, cũng chiếm toàn bộ địa bàn của Vô Lượng Đại Đế, nhưng vào lúc này, bọn họ gặp địch nhân cường đại, đó là đối thủ cũ. Lão Thần thú. Theo lý mà nói, lão Thần thú rời khỏi Đế đảo sẽ hóa đạo, nhưng mà, ai bảo người mang hắn đi là Đại Đế vô địch? Bọn họ có thể tùy ý ban phát yếu tố Sinh Mệnh để lão Thần thú có thể kéo dài tuổi thọ, cũng giống đám người Vô Nhai Đại Đế. Mà lão Thần thú là cấp thứ hai!\n" +
            "\n" +
            "Đại Đế cấp thứ hai xuất thủ, ai có thể ngăn cản? Cho dù đám người Vô Nhai Đại Đế đã tiến vào cấp thứ ba, trong tình huống một đấu một lại không phải đối thủ. Còn nữa, bọn họ cũng có điều cố kỵ, bởi vì Đại Đế toàn lực xuất thủ sẽ tạo thành phá hư quá lớn. Nhìn xem khi đó, mười hai tuyệt địa chi chủ chiến Huyền Thái Vũ đã làm khí vận Bắc Thiên vực giảm xuống ngàn vạn năm. Hiện tại, chẳng những số lượng Đại Đế càng nhiều, hơn nữa đều là chiến lực cấp thứ hai, cấp thứ ba, khi đó tạo thành phá hư lớn cỡ nào. Vô Lượng Đại Đế, lão Thần thú và đám người Lăng Hàn có khác biệt lớn nhất chính là, bọn họ cảm niệm thương sinh, thương xót chúng sinh. Lăng Hàn nhận được tin tức và chạy tới đng. Hắn đứng trong tinh không, đứng trên tinh cầu màu trắng, lão Thần thú tọa trấn tại nơi này. Sau lưng hắn là Nữ Hoàng, Đại Hắc Cẩu và đám người Vô Nhai Đại Đế. Lăng Hàn xuất thủ bắt lấy tinh cầu phía trước.\n" +
            "\n" +
            "Ông, đế uy tỏa ra, chỉ thấy lão Thần thú bị bắt vào tinh không. – Buồn cười, các ngươi lấy ở đâu ra dũng khí dám xâm chiếm nơi đây! Lão Thần thú cười lạnh, ánh mắt nhìn chằm chằm vào Lăng Hàn. – Tiểu bối, ngươi cho rằng thành tựu cấp thứ hai thì có thể so tài với ba vị kia? – A, lão già này tin tức lạc hậu, còn không biết Lăng Hàn đã đánh với Huyền Linh Đại Đế một trận. Đại Hắc Cẩu kinh ngạc nói. – Cũng đúng. Tiểu Thanh Long gật đầu. – Hắn chỉ là nô tài, Vô Lượng Đại Đế lại không cần báo cáo với hắn. – Ai, bảo Tiểu Hàn tử chúng ta đi chiến đấu với nô tài, đúng là mất mặt! Đại Hắc Cẩu lắc đầu. – Xem Cẩu gia làm sao trị hắn! Đại Hắc Cẩu xoay người, nó lấy mông chỉa vào lão Thần thú. – Tiểu bối, không muốn chết thì cút sang một bên, đừng có, a…\n" +
            "\n" +
            "Lão Thần thú muốn không đánh mà thắng, dù sao hắn đã đánh với Lăng Hàn, hắn còn không địch lại. Hắn chưa nói xong, hắn cảm thấy có ánh sáng chiếu tới và sáng đến mức mắt của hắn bị đau. Tình huống như thế nào? Hắn ngưng mắt nhìn sang, hắn nhìn thấy tiện cẩu đàng đưa mông về phía hắn, mà ánh sáng làm mắt hắn đau đớn tới từ đồ lót sắt. Mẹ nó! Cho dù với thực lực của lão Thần thú vẫn phải chảy nước mắt, đương nhiên không phải vì thương cảm, thuần túy chính là vì ánh sáng quá mạnh. Phải biết đây là siêu Đế binh, vốn có chiến lực cấp thứ năm, lực bộc phát có thể đạt tới cấp thứ tư, bây giờ lại bị Đại Hắc Cẩu dùng toàn lực chiếu sáng, lập tức gia tăng lực phá hoại lên rất lớn. Có thể thấy ánh sáng này chói mắt tới cỡ nào? Cấp thứ hai cũng bị chói mắt đến mức chảy nước mắt!','https://static.8cache.com/cover/eJzLyTDWr8g0KCmwdHIMCMp0MTQsNw9yMzXyczXLMXTyiTfNcEv3twzPzIvMTXRycwvON8gJzst1CsgLdw5zTDQ3SgyLMCkvLCgyL64odfENi_Dxcgq1LTcyNNXNMDYyAgCEwh2d/than-dao-dan-ton-606028.jpg',1)";
    private String SQLQuery6 = "INSERT INTO truyen VALUES (null,'Cầu Ma','Mười vạn năm.\n" +
            "\n" +
            "Hai mươi vạn năm.\n" +
            "\n" +
            "Ba mươi vạn năm.\n" +
            "\n" +
            "Mãi khi trăm vạn năm qua đi, Tô Minh ở trong thương mang vòng xoáy luân hồi lặng yên đi tới, dùng tất cả tu vi hóa thành thần thức, không buông tha khu vực nào, tìm kiếm kỹ càng từng chút một dấu vết trong luân hồi của họ.\n" +
            "\n" +
            "Dần dần, trong cô đơn Tô Minh đã quên làm sao mở miệng, quên phát ra thanh âm như thế nào. Người Tô Minh tràn ngập mệt mỏi, không phải mệt thể xác, vì hắn đã tơr thành Đạo Nhai, rất khó xảy ra chuyện thân thể suy yếu. Tô Minh mệt lòng. Không ngừng tìm, không ngừng thất vọng nhưng chưa từng từ bỏ, vì Tô Minh biết một khi buông tay sẽ không còn hy vọng nữa. Chỉ có tìm kiếm, dù khung trời chết, thương mang tắt Tô Minh vẫn phải đi tìm, đây là cố chấp, là con đường của hắn.\n" +
            "\n" +
            "Trăm vạn năm đầu tiên, Tô Minh đi trong thương mang như vậy, tìm tìm kiếm kiếm. Hai trăm vạn năm sau, Tô Minh vẫn như vậy. Tô Minh đi qua từng con Tang Tương, qua từng vòng xoáy lâun hồi. Mãi tới năm trăm vạn năm, mệt mỏi trong lòng Tô Minh biến thành áp lực, bi thương dung nhập vào linh hồn. Trong khu vực thương mang, Tô Minh tìm năm trăm vạn năm chợt khựng lại.\n" +
            "\n" +
            "Đây là lần đầu tiên Tô Minh dừng lại trong năm trăm năm. Tô Minh chậm rãi quay đầu nhìn thương mang, trong sương mù cuồn cuộn hắn thấy một mảnh vỡ. Mảnh vỡ tàn phá, bềnh bồng trong sương khói không biết đã tồn tại bao lâu rồi.\n" +
            "\n" +
            "Tô Minh nhìn chằm chằm vào mnahr vỡ, mắt bắn ra tia sáng. Tô Minh giơ tay phải chộp hướng sương mù. Sương mù bị ý chí vượt qua thương mang bao phủ, chớp mắt tĩnh lặng như không dám nhúc nhích. Mảnh vỡ bên trong sương mù lắc một cái lao nhanh hướng Tô Minh, nhẹ nhàng trôi nổi trong lòng bàn tay của hắn.\n" +
            "\n" +
            "Tô Minh nhìn mảnh vỡ trong lòng bàn tay, mặt dần lộ nét cười, nụ cười kia rất vui vẻ. Trong năm trăm vạn năm tìm kiếm, lần đầu tiên Tô Minh lộ nụ cười.\n" +
            "\n" +
            "Giọng Tô Minh khàn khàn vang lên:\n" +
            "\n" +
            "- Mã... Phi...\n" +
            "\n" +
            "Tô Minh im lặng năm trăm vạn năm, dường như đã quên cách phát ra thanh âm khiến lời nói của hắn khào khào, mơ hồ như người già gần đất xa trời.\n" +
            "\n" +
            "Phần lớn mảnh vỡ là đá, do vô số bụi trần trong thương mang ngưng tụ thành mảnh vỡ, cho nên nó luôn tồn tại trong vòng xoáy vì bản thân là một phần của bụi trần. Nhưng trong nhiều bụi trần mảnh vỡ có một hạt bụi bên trong ẩn chứa dấu vết Tô Minh quen thuộc. Đó là trong Đạo Thần chân giới, Đạo Trần tông, Tô Minh gặp một cô bé tên gọi là Mã Phi, là dấu vết thuộc về cô.\n" +
            "\n" +
            "Dù cô gái không là khuôn mặt Tô Minh muốn tìm nhất nhưng mảnh vỡ xuất hiện cho hắn niềm tin, cố chấp kiên định người ngoài khó thể tưởng tượng, khiến hắn hiểu rằng con đường tìm kiếm này là chính xác. Dù thời gian qua bao lâu, dù vài tìm mấy trăm vạn năm thì Tô Minh vẫn sẽ cố chấp tìm kiếm.\n" +
            "\n" +
            "Chấp niệm này chỉ vì gặp nhau.\n" +
            "\n" +
            "Tô Minh nhẹ nhàng nắm lấy mảnh vỡ trong lòng bàn tay, khi tay hắn xòe ra, mảnh vỡ tan biến. Bụi trần pha tạp trở thành tro bụi, chỉ có dấu vết thuộc về Mã Phi là như hồn phiến tàn phá bềnh bồng trong lòng bàn tay Tô Minh. Tô Minh trân trọng cất giữ.\n" +
            "\n" +
            "Hồi lâu sau Tô Minh ngẩng đầu lên, trong mắt của hắn lộ tia sáng lấp lánh, mắt trong suốt như con nít. Tô Minh tiến tới trước, cố chấp đi tiếp.\n" +
            "\n" +
            "Thời gian trôi qua, lại là trăm vạn năm, tìm kiếm mỗi một năm, các lần không tiếc dốc hết tu vi hóa thành thần thức đi qua từng vòng luân hồi thương mang.\n" +
            "\n" +
            "Tô Minh không biết sẽ tìm đến khi nào, có lẽ là suốt đời, dùng sinh mệnh dài lâu của Đạo Nhai không ngừng tìm. Giống như Huyền Táng trong trí nhớ của Tô Minh tĩnh tọa trên la bàn, không biết y đã ngồi bao nhiêu năm.\n" +
            "\n" +
            "Khi qua năm ngàn vạn năm, biểu tình của Tô Minh đã gần như chết lặng, người hắn bắt đầu xuất hiện một ít tử khí. Tử khí không phảivì tuổi thọ đã tận mà bởi cô đơn, lạc lõng trong thương mang khiến lòng Tô Minh liên tục mệt mỏi, tìm kiếm lâu trở nên tĩnh lặng.\n" +
            "\n" +
            "Nhưng dù có tĩnh lặng vẫn không thể ngăn cản Tô Minh đi tìm, dù hắn không dùng đôi chân bước đi, dù thật lâu trước kia hắn khoanh chân tiến tới trong thương mang vẫn không thể chôn vùi nỗi mong chờ gặp lại ỏng lòng Tô Minh.\n" +
            "\n" +
            "Tìm, tìm, tìm.\n" +
            "\n" +
            "Tám ngàn vạn năm đến, Tô Minh tìm thấy dấu vết của Diệp Vọng. Giống con người Diệp Vọng, dấu vết của y phát ra tia sắc bén, chói mắt, đó là sừng trên đầu một mãnh thú tồn tại trong thương mang. Mãnh thú nằm sấp trước mặt Tô Minh, người run run. Mãnh thú chỉ cảm nhận một tia hơi thở của Tô Minh lại chấp nhiếp nó suýt chết.\n" +
            "\n" +
            "Tô Minh nhìn sừng con thú, giơ tay phải chỉ tới trước, khi rụt lại thì trong lòn bàn tay của hắn xuất hiện hồn phiến Diệp Vọng.\n" +
            "\n" +
            "Tô Minh quý trọng cất đi hồn phiến, nhắm mắt lại, tiếp tục tìm kiếm.\n" +
            "\n" +
            "Thời gian trôi qua, Tô Minh tìm kiếm không biết đã qua bao nhiêu kỷ nguyên, tám con bươm bướm trong thương mang đã bao lần khép bốn cánh lại.\n" +
            "\n" +
            "Mãi khi hai vạn năm ngàn vạn năm qua đi, Tô Minh ở trong thương mang chợt run lên, mở mắt ra. Trong mắt Tô Minh bắn ra tia sáng rực rỡ nhất trong bao nhiêu năm qua, ánh sáng chói mắt khiến nguyên thương mang chấn động, cánh tám con bươm bướm run rẩy không nhúc nhích.\n" +
            "\n" +
            "Vẻ mặt Tô Minh kích động chưa từng có, chậm rãi đứng dậy, bước chân đạp xuống run run. Mắt Tô Minh nhìn chằm chằm một đóa hoa trắng nhỏ sinh ra trong sương mù trước mặt. Sương mù như màn mưa, đóa hoa trắng nhỏ ở bên trong chờ đợi cơn mưa đến. Trông hoa thật yếu ớtn hưng có kiên cường đặc biệt, dường như đnag chờ, đợi người nó chờ đi tới.\n" +
            "\n" +
            "Chờ đợi hơn hai vạn năm ngàn vạn năm, chờ người đưa đò bên sông vong xuyên che mưa gió cho nó, mang hoa lên thuyền.\n" +
            "\n" +
            "Mắt Tô Minh chảy lệ nhưng mặt lại nở nụ cười vui vẻ. Tô Minh chậm rãi đến gần đóa hoa trắng nhỏ, nhìn chăm chú, hé môi như muốn nói gì nhưng không có thnah âm phát ra.\n" +
            "\n" +
            "Vì Tô Minh đã quên nói chuyện.\n" +
            "\n" +
            "Tô Minh không để ý chuyện này, hắn cười vui vẻ, dù nụ cười không thanh âm nhưng nó xuất hiện làm cả thương mang gợn sóng. Trong sóng gợn lăn tăn, Tô Minh nhẹ nhàng giơ tay lên, nâng niu đóa hoa trắng nhỏ vào lòng bàn tay, rời khỏi sương mù.\n" +
            "\n" +
            "Giọt nước nơi khóe mắt Tô Minh trượt xuống gò má, có một giọt rơi vào đóa hoa, như giọt sương. Đóa hoa trắng nhỏ vươn cành lá, nở lộ ra nụ cười yêu kiều làm Tô Minh hoảng hốt.\n" +
            "\n" +
            "Cành lá nhẹ nhàng chạm vào tay Tô Minh, cảm giác mềm mại tuyệt vời như trong ký ức của hắn.\n" +
            "\n" +
            "Tô Minh nhìn đóa hoa trắng nhỏ trong lòng bàn tay, nụ cười vui vẻ của hắn ảnh hưởng luân hồi vòng xoáy. Tô Minh đã tìm được Vũ Huyên.\n" +
            "\n" +
            "Tô Minh nhẹ nhàng cất đóa hoa vào thế giới trong cơ thể, từ quý trọng biến thành quý giá làm bạn hắn, như năm xưa bên sông vong xuyên, bên cạnh thân hình mặc áo tơi cô đơn, dưới mái hiên yên lặng làm bạn.\n" +
            "\n" +
            "Đóa hoa trắng nhỏ trong mưa tên là Huyên, không có ưu thương. Đối với Tô Minh, đây là sự cố chấp, để ý của hắn, mang đến ánh nắng cho cuộc đời hắn. Trong năm tháng sau này, Tô Minh ở trong luân hồi thương mang tìm đến từng dấu vết một.\n" +
            "\n" +
            "Những dấu vết này không có khuôn mặt khiến Tô Minh cố chấp nhưng từng ký ức, những người vốn là khách qua đường, dù là kẻ thù hay người xa lạ lướt qua vai nhau thì Tô Minh đều quý trọng mang đi dấu vết. Giờ phút này, Tô Minh không còn đối địch với bất cứ sinh mệnh nào.\n" +
            "\n" +
            "Tô Minh tìm thấy Tô Hiên Y, thấy mọi người trong đất Man tộc, thấy dấu vết còn sót lại của thần nguyên tinh hải, thấy Đức Thuận của Đạo Thần tông, thấy cố nhân trong Tam Hoang đại giới, và điên cuồng trong Ám Thần Nghịch Thánh.\n" +
            "\n" +
            "Trong thương mang từng lần luân hồi mãi khi Tô Minh tìm ra Trường Hà, hắn nhìn chăm chú vào dấu vết bên cạnh Trường Hà, thấy dấu vết một nữ nhân xa lạ.\n" +
            "\n" +
            "Nữ nhân gắn bó với dấu vết Trường Hà, đó là người vợ đã chết của gã. Tô Minh nhìn chăm chú, phát hiện thì ra vợ của Trường Hà luôn ở bên cạnh gã, chẳng qua lúc còn sống gã không phát hiện.\n" +
            "\n" +
            "Tô Minh tìm dấu vết khắp nơi, đi trong luân hồi, trong năm tháng. Không biết qua bao nhiêu ngàn vạn năm sau, Tô Minh tìm đến đại sư huynh. Dấu vết của Đại sư huynh không phải bụi trần mà là chiến ý, nó hư ảo tồn tại trong chủng tộc một đám mãnh thú trong sương mù thương mang, trở thành chiến ý điên cuồng của chúng nó.\n" +
            "\n" +
            "Cuộc chiến trường tồn.\n" +
            "\n" +
            "Tô Minh mang theo dấu vết tìm khắp nơi, mang theo cố chấp đi qua sương mù, khi bước qua sương mù vòng quanh hắn như không muốn tán đi, không muốn rời xa hắn. Trong sương mù có tiếng rì rầm như nói điều gì.\n" +
            "\n" +
            "Tô Minh dừng bước, cúi đầu nhìn sương bên cạnh mình, thật lâu sau mắt đọng lại thâm tình. Tô Minh tìm thấy Phương Thương Lan, cô là sương mù này, hoặc nên nói là cô tìm hắn.\n" +
            "\n" +
            "Tô Minh mang đi sương mù, mang Phương Thương Lan đi, lòng hắn ngày càng mong chờ. Nhưng Tô Minh sớm hiểu ngày minh giới mở ra, khi mọi dấu vết hóa thành khắc ấn sinh mệnh, ngày xuất hiện tùng lặp.\n" +
            "\n" +
            "Từ đó Tô Minh chỉ có thể lặng im nhìn. Bạn đang xem truyện được sao chép tại: TruyenFull.vn chấm c.o.m\n" +
            "\n" +
            "Đây không phải là số mệnh đã định, nó là cái giá đạo của Tô Minh, là con đường hắn lựa chọn khác với Diệt Sinh lão nhân.','https://static.8cache.com/cover/o/eJzLyTDT1w30jiw09c_SzTJx1A-NN4oyrywKKsn01HeEgqwsA_3iLIuiAMMCc9fSZP1yI0NT3QxjIyMAUKcScA==/cau-ma.jpg',1)";
    private String SQLQuery7 = "INSERT INTO truyen VALUES (null,'Tiên Nghịch','Trần Đào âm trầm một lúc lâu, rồi bình thản nói:\n" +
            " \n" +
            "-Ngươi sẽ không hiểu được những gì hắn đang phải đấu tranh vào lúc này đâu, giống như người sẽ không bao giờ hiểu được tâm của tiên nhân.\n" +
            " \n" +
            "Thạch Tiêu xoay người nhìn Trần Đào, hắn lại trở nên trầm ngâm. Vẻ lạnh lùng trong mắt Mặc Phi lại ngày càng đậm, hắn nhìn Vương Lâm, khẽ nói:\n" +
            " \n" +
            "-Ngươi và hắn năm xưa đều là loại người được người khác hâm mộ, thú vị thật!\n" +
            " \n" +
            "Tu sĩ Đại La Kiếm Tông đứng ở phía sau Mặc Phi là người duy nhất nghe được câu nói của hắn. Tu sĩ kia trong lòng run lên rồi cúi đầu không nói câu nào.\n" +
            " \n" +
            "Huyền Hôn soái trên khán đài khẽ than nhẹ một tiếng. Hắn không phải tu sĩ, nhưng đã đến thân phận như hắn cũng biết đại khái một số chuyện của tu sĩ Vấn Đỉnh. Tuy hắn không hiểu nhiều nhưng lúc này nhìn thấy Vương Lâm ngừng tay, hắn cũng hiểu được một chút chuyện.\n" +
            " \n" +
            "Giờ khắc này, trên con thuyền đang neo trên mặt sông bên ngoài Đế Đô, người thanh niên đã cùng Vương Lâm uống rượu cả đêm đang ngồi trên mũi thuyền. Hắn ngửa cổ uống sạch chén rượu trong tay rồi khẽ nói:\n" +
            " \n" +
            "-Tiểu tử kia, ngươi sẽ lựa chọn như thế nào đây… ….\n" +
            " \n" +
            "Người con gái đánh đàn vẫn đang ngồi trên đầu thuyền, nhưng lúc này nàng lại không đánh đàn mà chỉ lẳng lặng ngồi ở chỗ đó.\n" +
            " \n" +
            "Tay Vương Lâm vẫn còn dừng lại cách mặt trống một tấc, hắn ngơ ngẩn nhìn Yêu Cổ.\n" +
            " \n" +
            "-Đạo tâm đã viên mãn, chỉ cần quét sạch những bi thương trong nội tâm là được, nhưng như vậy…Đáng giá sao?\n" +
            " \n" +
            "Hình bóng Lý Mộ Uyển lại hiện ra trước mắt hắn, giống như một dòng nước mát khẽ chảy qua.\n" +
            " \n" +
            "-Nếu đây là cái giá phải trả để quét sạch những bi thương trong lòng, dùng phương pháp xóa bỏ đi hình bóng của Uyển Nhi để đạt đến Vấn Đỉnh, thì đạo của ta là gì? Đạo của ta từ lúc còn sống đến khi chết đi cho đến khi ngủ say vĩnh cửu đều là Uyển Nhi. Nếu ta thật sự phải vỗ tay xuống, nàng sẽ vô tình trở thành Lô Đỉnh của ta… ….\n" +
            " \n" +
            "-Vương Lâm ta thân là nam nhi, mặc dù không phải đội trời đạp đất, nhưng sống cũng không thẹn với lương tâm. Đạo trời bạc bẽo, nếu ta lại vô tình thì sẽ không phải nghịch thiên mà đi, sẽ trở thành thuận thiên.\n" +
            " \n" +
            "-Vứt bỏ những tình cảm trong lòng, những Yêu tướng này cũng giống như tu sĩ đều đang trốn chạy. Phương pháp tu hành này không phải là đạo của Vương Lâm ta!\n" +
            " \n" +
            "-Đạo của Vương Lâm ta là ngịch, nghịch thiên mà đi, đây mới là con đường của ta. Tu sĩ thượng cổ phải dối trời để tu hành, bây giờ ta đã hiểu rõ hai chữ dối trời này. Đây không phải là dối trời mà phải là chạy trốn. Tuy không phải thuận lòng trời nhưng con đường cuối cùng cũng chỉ là một! - Trong mắt Vương Lâm lộ ra một tia sáng.\n" +
            " \n" +
            "-Ta có thể quét sạch những bi thương trong lòng, nhưng những gì trong lòng ta nắm giữ, cho dù là thiên đạo cũng đừng hòng cướp đi!\n" +
            " \n" +
            "Giờ khắc này, Vương Lâm mạnh mẽ ngẩng cao đầu nhìn lên bầu trời.\n" +
            " \n" +
            "Trên người hắn đột nhiên tuôn ra một luồng khí tức cực kỳ kinh người. Khí tức này không mạnh nhưng lại làm cho tất cả mọi người ở khắp bốn phía, cho dù là Thiên soái cũng cảm thấy run lên.\n" +
            " \n" +
            "Khí tức này giống như những thanh kiếm sắc từ trên người Vương Lâm lao ra rồi trực tiếp đâm lên bầu trời. Trong khoảnh khắc, những tầng mây trên trời buộc phải tản ra, trời đất đột nhiên trở nên rực sáng.\n" +
            " \n" +
            "-Đây! Đây là… ….\n" +
            " \n" +
            "Với định lực của Thiên soái mà lúc này cũng không kìm được phải biến sắc, trong ánh mắt hắn nhìn về phía Vương Lâm lộ ra vẻ kinh hãi!\n" +
            " \n" +
            "-Không ngờ hắn lại lựa chọn giống như Yêu Đế năm xưa!\n" +
            " \n" +
            "Thiên soái hít vào một hơi thật sâu rồi nhìn về phía Vương Lâm.\n" +
            " \n" +
            "Vẻ mặt người đàn ông mặc kim giáp lại càng trở nên tái nhợt. Khoảnh khắc khi Vương Lâm dừng tay lại hắn còn thầm kêu may mắn. Nhưng lúc này khí thế từ trên người Vương Lâm tản ra lại làm hắn cảm thấy giống như đại nạn sắp đổ sập xuống đầu.\n" +
            " \n" +
            "Hắn nhìn chằm chằm vào bóng lưng Vương Lâm, sát khí trong mắt hắn tăng lên điên cuồng.\n" +
            " \n" +
            "-Khi hắn còn chưa đánh được mười lăm tiếng trống, ta giết hắn thì ngày sau chắc chắn sẽ bị Yêu Đế trách cứ nhưng cũng không phải vì người này mà trừng phạt ta quá nặng. Tất nhiên người này cũng chỉ là một tên tu sĩ, mà ta không chỉ là Yêu nhân đồng thời còn là người từng lập được công lao với Thiên Yêu quận.\n" +
            " \n" +
            "Khí thế trên người Vương Lâm vừa mới bùng lên lại lập tức biến mất.\n" +
            " \n" +
            "-Con đường tu đạo chân chính là nghịch thiên. Ta không tin chỉ có cách vứt bỏ hết những bi thương trong lòng mới có thể tiến lên Vấn Đỉnh. Cảnh giới Vấn Đỉnh không phải là thiên định mà do tu sĩ tự quyết định. Trời không thể cưỡng chế và quấy nhiễu ta được, thật sự ảnh hưởng chỉ có tâm của tu sĩ.\n" +
            " \n" +
            "-Nêu tâm thỏa hiệp thì không thể nghịch, là bị trời lừa gạt. Nếu tâm kiên định, trời cứ mở mắt nhìn ta ngày hôm nay làm sao tiến lên Vấn Đỉnh, làm sao cản trở ta nghịch thiên tu hành!\n" +
            " \n" +
            "Trong mắt Vương Lâm lộ ra tinh quang, hắn hít vào một hơi thật sâu. Hắn không chút cố kỵ đem hết tất cả những bi niệm đối với Lý Mộ Uyển đặt lên trên tay phải. Giờ khắc này thiên địa đã hoàn toàn biến sắc, sấm chớp xuất hiện dày đặc trên bầu trời.\n" +
            " \n" +
            "Những dị tượng trên bầu trời Đế Đô lập tức kinh động đến tất cả mọi người ở Thiên Yêu thành. Trong khoảnh khắc này, tất cả mọi người đều phải ngẩng đầu lên nhìn về phía Đế Đô.\n" +
            " \n" +
            "Trên quảng trường vạn trượng, tất cả ánh mắt mọi người đều đặt lên trên thân ảnh nhỏ bé của Vương Lâm.\n" +
            " \n" +
            "Ngay cả người thanh niên đang ở trên thuyền cũng phải buông chén rượu xuống, hắn đứng thẳng người lên nhìn về phía Đế Đô, trong mắt lộ ra một tia kỳ vọng.\n" +
            " \n" +
            "Giờ khắc này ở một nơi cách Thiên Yêu thành rất xa, trên tầng cao nhất của một ngọn tháp màu đen đang gầm rống hấp thu âm hồn trong chiến trường viễn cổ.\n" +
            " \n" +
            "Trên mũ sắt của một bộ giáp màu đen đột nhiên lấp lánh u quang. Trong nháy mắt khi u quang lấp lánh, tất cả bầu trời bên ngoài tòa tháp đột nhiên xuất hiện từng cơn dao động làm người ta phải kinh hoàng.\n" +
            " \n" +
            "Khi u quang chớp động, một thần niệm đột nhiên từ trong tòa tháp vang vọng ra bên ngoài:\n" +
            " \n" +
            "-Ngịch tu…Tốt lắm!\n" +
            " \n" +
            "Trên quảng trường Đế Đô, Vương Lâm dồn hết tất cả bi thương ngưng tụ trên cánh tay phải. Giờ khắc này, tay phải của hắn đã chứa rất nhiều đau thương, đột nhiên hắn vỗ tay về phía Yêu Cổ!\n" +
            " \n" +
            "Trong khoảnh khắc, hai mắt người đàn ông mặc kim giáp đột nhiên bùng lên một luồng sát khí mãnh liệt. Cơ thể hắn đột nhiên khẽ động, toàn bộ tu vi dồn hết lên đôi chân, thân ảnh của hắn đã phóng thẳng đến chỗ Vương Lâm nhanh đến mức không thể tưởng tượng.\n" +
            " \n" +
            "-Nhận lấy cái chết!\n" +
            " \n" +
            "Người đàn ông mặc kim giáp hét lớn một tiếng, lúc này hắn đã phóng đến phía sau Vương Lâm, tay phải hắn bộc phát ra những luồng hào quang giống như ánh sáng mặt trời, giống như hắn lấy mặt trời đặt vào trong tay.\n" +
            " \n" +
            "-Ta không thể để ngươi đánh được tiếng thứ mười lăm! Giết ngươi rồi, ta không tin Đế Quân sẽ trách phạt!\n" +
            " \n" +
            "Sát khí trong mắt người đàn ông mặc kim giáp đã giống như hóa thành thực chất bắn ra khắp bốn phía.\n" +
            " \n" +
            "Trong nháy mắt khi những luồng sáng rực rỡ trên tay phải hắn đến gần thì khắp mặt đất đột nhiên bốc cháy, trong chu vi trăm trượng đột nhiên bốc lửa giống như địa ngục.\n" +
            " \n" +
            "Trên quảng trường, trong mắt Thiên soái đột nhiên lấp lánh hàn quang, cơ thể hắn phóng thẳng từ trên xuống rồi hét lớn:\n" +
            " \n" +
            "-Kim Ô Húc! Ngươi muốn làm gì?\n" +
            " \n" +
            "Lúc này Vương Lâm quay đầu lại nhìn người đàn ông mặc kim giáp. Người này đột nhiên xuất hiện không nằm ngoài dự liệu của hắn. Hắn đã biết người này sẽ tuyệt đối không cam lòng nhận thua. Ba nghìn đạo Sinh Chi Lạc Ấn đã sớm được hắn chuyển lên khắp toàn thân, đồng thời nhờ vào uy lực của tiếng trống thứ mười lăm, Vương Lâm tin hắn có thể chống lại được một quyền này!\n" +
            " \n" +
            "Khóe miệng người đàn ông mặc kim giáp lộ ra một nụ cười lạnh, tay phải hắn giống như đang cầm mặt trời đánh thẳng về phía Vương Lâm. Hắn lợi dụng thời cơ rất tốt, nếu Vương Lâm tránh đi thì sẽ không đánh được tiếng trống thứ mười lăm. Hơn nữa nếu người này thối lui hắn sẽ lập tức truy sát. Nếu tên này không tránh, người đàn ông mặc kim giáp cũng tin có thể đánh chết người này trước khi hắn kịp đặt tay lên mặt trống.\n" +
            " \n" +
            "Ngươi đàn ông mặc kim giáp căn bản không thèm để ý đến câu nói của Thiên soái, trong mắt hắn lộ ra một tia tàn nhẫn. Trong nháy mắt khi Thiên soái phóng tới, tay trái của người đàn ông mặc kim giáp đã vỗ về phía sau. Trong quá trình giết chết Vương Lâm, hắn không cho phép bất cứ người nào đứng ra ngăn cản.\n" +
            " \n" +
            "Tay phải Thiên soái bấm pháp quyết rồi hóa thành một đạo ô quang đánh thẳng vào tay trái của người đàn ông mặc kim giáp.\n" +
            " \n" +
            "Lúc này, sắc mặt người thanh niên đang ngồi thuyền trên sông đột nhiên trở nên âm trầm, trong mắt hắn lộ ra vẻ tức giận, hắn quát khẽ:\n" +
            " \n" +
            "-To gan! Kim Ô Húc! Ngươi thật đáng chết!\n" +
            " \n" +
            "Trong nháy mắt, cơ thể người đàn ông mặc kim giáp đang đứng vững trên quảng trường đột nhiên run rẩy, sát khí trong mắt hắn giống như bị nước lạnh dập tắt, những ngọn lửa trong phạm vi trăm trượng đột nhiên trở nên ảm đạm. Trong tai hắn vang vọng những dư âm ầm ầm, sắc mặt hắn trở nên tái nhợt rồi nghẹn ngào nói:\n" +
            " \n" +
            "-Giọng nói này!\n" +
            " \n" +
            "Đúng lúc này, trong ngọn tháp trên chiến trường viễn cổ ở rất xa Thiên Yêu Thành, trong hốc mắc của chiếc áo giáp đột nhiên lấp lánh u quang rồi lập tức bùng lên, một tiếng hừ lạnh ẩn chứa bên trong thần niệm đột nhiên trở nên vang vọng!\n" +
            " \n" +
            "Ba chữ \"Giọng nói này!\" vừa mới được người đàn ông mặc kim giáp nói ra khỏi miệng thì một cổ âm hàn đã lập tức bao phủ khắp toàn thân hắn. Những ngọn lửa giống như địa ngục ở trong chu vi trăm trượng đột nhiên tan biến!\n" +
            " \n" +
            "Một tiếng hừ hạnh từ trong hư vô truyền vào trong tai người đàn ông mặc kim giáp.\n" +
            " \n" +
            "Cở thể người đàn ông mặc kim giáp đột nhiên chấn động kịch liệt, kim giáp trên toàn thân lập tức tan vỡ rồi hóa thành những mảnh nhỏ. Hắn phun ra một ngụm máu lớn, mặt trời trên cánh tay phải của hắn lập tức tàn lụi.','https://static.8cache.com/cover/o/eJzLyTDT1w0sDgtMCjFO8XMO1A9zCvSLTK5wzDL01HeEguyAQH3v0IK8TK_i-IjCSP1yI0NT3QxjIyMAV4kSwQ==/tien-nghich.jpg',1)";
    private String SQLQuery8 = "INSERT INTO truyen VALUES (null,'Tam thốn nhân gian','Bất quá dù tản chút hỏa khí, nhưng khi đó cái này Tạ Hải Dương ăn ba nhà hành vi, vẫn là để Vương Bảo Nhạc đáy lòng rất là dính nhau, mặc dù biết thương nhân trục lợi sự tình, có thể Vương Bảo Nhạc cảm thấy mình bị thương rất nặng.\n" +
            "\n" +
            "\"Hải Dương huynh đệ, ta thế nhưng là đem ngươi trở thành bằng hữu, ngươi lại bán đứng ta. . .\" Vương Bảo Nhạc nhẹ giọng mở miệng, trong thanh âm lộ ra chân thành, càng ẩn chứa một chút thương cảm, rơi vào Tạ Hải Dương trong tai, khiến cho hắn cũng đều trầm mặc một chút, cuối cùng nở nụ cười khổ.\n" +
            "\n" +
            "\"Bảo Nhạc huynh đệ, chuyện này. . . Là ta làm qua, coi như ta thiếu ngươi một cái nhân tình.\"\n" +
            "\n" +
            "\"Được rồi, ngươi mới vừa nói phải cho ta tiễn đưa một chút tài nguyên, cái này tài nguyên ta cũng không cần, dạng này. . . Ta hiện tại gặp được một chút phiền toái nhỏ, ngươi xem một chút cho ta giải quyết đi.\" Vương Bảo Nhạc tằng hắng một cái, cảm thấy mình cũng không phải người nhỏ mọn, đã Tạ Hải Dương nơi này thành tâm, như vậy mình cũng không tốt nắm lấy đã từng sự tình không buông tay, thế là rất là tùy ý đem mình bây giờ gặp phải vấn đề, nói ra.\n" +
            "\n" +
            "Không có đi giấu diếm cái gì, Vương Bảo Nhạc trực tiếp nói cho Tạ Hải Dương, bởi vì lúc trước trong Hoàng Lăng sự tình, thân phận của mình bị lộ ra về sau, đưa tới Tử Kim văn minh chú ý, cho nên bọn họ đối với mình làm cục, làm mình nơi này cửu tử nhất sinh, dù miễn cưỡng chạy thoát, nhưng vẫn là bị vây ở cái này địa linh văn minh.\n" +
            "\n" +
            "Đồng thời hắn cũng điểm ra, lưu cho mình thời gian không nhiều, Tử Kim văn minh Thiên Linh tông Hữu trường lão, lúc nào cũng có thể sẽ theo đuổi giết chính mình.\n" +
            "\n" +
            "Dù đang chân tướng sự tình bên trên không có giấu diếm, chẳng qua là khoa trương một chút, để việc này cùng Hoàng Lăng chi hành mật thiết móc nối, tạm Vương Bảo Nhạc ngôn từ bên trên nhưng không có lộ ra vội vàng, có thể nghe vào Tạ Hải Dương trong lỗ tai, hắn lập tức hiểu, đây là Vương Bảo Nhạc là ám chỉ mình, bởi vì chuyện lúc trước, bây giờ lưu lại tai hoạ ngầm, cho nên cuối cùng, mình nếu là thành tâm tạ lỗi, như vậy thì muốn giúp lấy giải quyết vấn đề này.\n" +
            "\n" +
            "Đồng thời loại này ám chỉ, cũng khiến cho hắn căn bản là không cách nào mở miệng đi chào giá, trong này chi tiết chỗ, khó mà dùng ngôn từ đi hoàn mỹ thuyết minh, chỉ có chân chính cảm thụ trong lòng, mới có thể minh ngộ ngôn ngữ mị lực.\n" +
            "\n" +
            "Thế là Tạ Hải Dương lần nữa cười khổ, đáy lòng lại đối Vương Bảo Nhạc càng trọng thị, hắn cảm thấy dạng này Vương Bảo Nhạc, lột xác thành cường giả tỉ lệ, hiển nhiên cực lớn.\n" +
            "\n" +
            "Trên thực tế hắn sở dĩ đang ăn ba nhà về sau, nơi này khắc đối Vương Bảo Nhạc biểu đạt áy náy, cũng là nguyên nhân này, hắn trực giác Vương Bảo Nhạc người này, vô luận là tính cách vẫn là thủ đoạn, đều cực kì không tầm thường, nhất là bối cảnh nhìn như đơn giản, nhưng lại cất giấu để hắn cũng đều đoán không ra mê vụ.\n" +
            "\n" +
            "Dù là không đi suy tư mê vụ tồn tại, vẻn vẹn dựa vào Liệt Diễm lão tổ đều nghĩ thu người này là đồ, cũng có thể nhìn ra Vương Bảo Nhạc tuyệt không phải bình thường, càng quan trọng hơn là, thu đồ đệ sự tình thế mà còn bị đối phương cự tuyệt, tạm coi như đến bây giờ loại nguy hiểm này trình độ, đối phương tựa hồ cũng không muốn liên hệ Liệt Diễm lão tổ đồng ý bái sư.\n" +
            "\n" +
            "Cho nên. . . Hắn cho rằng Vương Bảo Nhạc có cậy vào cùng át chủ bài, nhất định cực lớn.\n" +
            "\n" +
            "Đây hết thảy, khiến cho Tạ Hải Dương trầm ngâm một phen, lập tức mở miệng.\n" +
            "\n" +
            "\"Rời đi nơi này trở lại Thần Mục văn minh, việc này đơn giản, ta có thể vận dụng một lần quyền hạn, miễn ngươi một lần Thánh Vực truyền tống phí tổn, khiến cho ngươi trực tiếp liền truyền tống đến ta trú lưu phường thị, coi đây là trung chuyển, ngươi trở lại Thần Mục văn minh thời gian, sẽ bị vô hạn rút ngắn.\"\n" +
            "\n" +
            "\"Bất quá. . . Truyền tống dễ nói, nhưng cái này Tử Kim văn minh nhân tạo Hằng Tinh bên trong ẩn chứa phong ấn, muốn phá vỡ vẫn còn có chút phiền phức, Tử Kim văn minh nhân tạo Hằng Tinh dù cấp độ không cao, có thể cuối cùng ẩn chứa Hằng Tinh chi lực. . . Tạm Tạ gia chúng ta là người làm ăn, quy củ rất trọng yếu ah, không thể không có bất luận cái gì nguyên do, liền lấy lớn hiếp nhỏ ah.\"\n" +
            "\n" +
            "Nghe Tạ Hải Dương lời nói, Vương Bảo Nhạc lông mày nhướn lên, vừa muốn mở miệng, Tạ Hải Dương bên kia giống như có thể đoán được ý nghĩ của hắn đồng dạng, vội vàng truyền ra lời nói.\n" +
            "\n" +
            "\"Bảo Nhạc huynh đệ, ta cũng không phải muốn thu phí ah, mà là muốn phá vỡ cái này phong ấn, ta cần một chút thời gian. . .\" Tạ Hải Dương mở miệng đồng thời, ngồi đang phường thị trong lầu các, trong mắt lộ ra trầm ngâm, hắn đang suy nghĩ chuyện này xử lý như thế nào, mới có thể hiển lộ bản sự của mình đồng thời, lại có thể để Vương Bảo Nhạc đối với mình nơi này triệt để hòa hoãn, tạm còn có thể thêm ra một chút kính sợ.\n" +
            "\n" +
            "Hắn dù cũng coi Vương Bảo Nhạc là thành bằng hữu, mà dù sao là thương nhân, dù là giữa bằng hữu, hắn đầu tiên cân nhắc cũng vẫn là giá trị, vô luận là đối phương giá trị, vẫn là giá trị của mình, cái trước có thể để hắn càng muốn kết giao, mà cái sau thì là làm cho đối phương, cũng càng mưu cầu danh lợi kết giao chính mình.\n" +
            "\n" +
            "Về phần đơn thuần giải quyết Vương Bảo Nhạc hiện tại gặp phải phiền phức, đối Tạ Hải Dương tới nói ngược lại là rất đơn giản, hắn muốn cân nhắc, là dùng một loại phương pháp nào mới hoàn mỹ nhất.\n" +
            "\n" +
            "Những ý niệm này đang đầu óc hắn chớp mắt hiện lên về sau, Tạ Hải Dương ánh mắt có chút lóe lên, khóe miệng lộ ra tiếu dung, lập tức lần nữa truyền âm.\n" +
            "\n" +
            "\"Bảo Nhạc huynh đệ, truyền tống phí tổn ngươi không cần cân nhắc, ta miễn phí tiễn đưa ngươi một lần, về phần cái này phá vỡ phong ấn phí tổn, cũng được, ngươi ta huynh đệ ở giữa, ta cũng cho ngươi miễn trừ, cho ta nửa tháng, ta nhất định có thể giúp ngươi mở ra cái này phong ấn!\"\n" +
            "\n" +
            "Vương Bảo Nhạc nghe đến đó, con mắt dần dần nheo lại, ẩn ẩn cảm thấy, đối phương lời nói này bên trong, giống như cất giấu cái khác hàm nghĩa, nhưng trong lúc nhất thời có chút phân tích không ra, thế là không nói gì , chờ đợi đối phương tiếp tục mở khẩu.\n" +
            "\n" +
            "\"Bất quá Bảo Nhạc huynh đệ ah, ta cảm thấy ngươi bây giờ cần nhất, không phải phá vỡ phong ấn, cũng không phải truyền tống, mà là. . . Bình An!\"\n" +
            "\n" +
            "Vương Bảo Nhạc trong mắt tinh mang lóe lên, nhàn nhạt truyền ra lời nói.\n" +
            "\n" +
            "\"Hải Dương huynh đệ, ngươi câu nói này. . . Có ý tứ gì?\"\n" +
            "\n" +
            "\"Bảo Nhạc huynh đệ, ta liền nói thẳng ah, ta chỗ này nghiệp vụ bao hàm toàn diện, cái gì đều có thể bán, bao quát. . . Bình An!\" Tạ Hải Dương cười cười, trong thanh âm ẩn chứa sự tự tin mạnh mẽ.\n" +
            "\n" +
            "\"Bình An? Làm sao mua?\" Vương Bảo Nhạc mày nhăn lại, nội tâm hơi nghi hoặc một chút, ám đạo không phải là mua bảo tiêu không thành.\n" +
            "\n" +
            "\"Bình An ngọc bài ah, thời hạn có hiệu lực dựa theo Liên Bang lịch ngày đi tính, có một năm có tác dụng trong thời gian hạn định, ngươi chỉ cần mua, trên cơ bản không ai dám trêu chọc, gặp được bất cứ địch nhân nào, trực tiếp xuất ra tấm bảng này, đối phương sau khi thấy nhất định tránh lui trên trăm năm ánh sáng bên ngoài, sợ hãi hận không thể lập tức cho ngươi quỳ xuống cầu xin tha thứ.\" Tạ Hải Dương đắc ý giới thiệu Bình An ngọc bài công hiệu, ngôn từ bên trong tràn đầy dụ hoặc.\n" +
            "\n" +
            "Vương Bảo Nhạc sau khi nghe, nửa tin nửa ngờ, thế là hỏi giá cả, kết quả Tạ Hải Dương vừa báo giá, Vương Bảo Nhạc thần sắc cổ quái, cảm thấy như có ngàn vạn con ngựa ở trong lòng lao nhanh mà qua, lời nói đều không nói, trực tiếp liền đem truyền âm cúp máy.\n" +
            "\n" +
            "Rất nhanh, hắn truyền âm ngọc giản truyền ra chấn động, Tạ Hải Dương gượng cười thanh âm từ bên trong truyền ra.\n" +
            "\n" +
            "\"Bảo Nhạc Bảo Nhạc, ngươi nghe ta nói. . .\"\n" +
            "\n" +
            "\"Không cần nói, mua không nổi!\" Vương Bảo Nhạc nhàn nhạt mở miệng.\n" +
            "\n" +
            "\"Ngươi nhìn, tại sao lại tức giận chứ, ta còn chưa nói xong ah, ngươi ta là huynh đệ, ngươi lại là ta khách quý, dạng này, ta trước tiên có thể cho ngươi một tháng thử việc như thế nào? Một tháng Bình An, không cần tiền, ngươi nếu là dùng tốt, quay đầu lại tới tìm ta mua chính thức bản, thế nào?\"\n" +
            "\n" +
            "\"Tạ Hải Dương, ta thế nào cảm giác ngươi nơi này có mờ ám ah, ngươi xác định cái này Bình An thẻ bài không có vấn đề?\" Vương Bảo Nhạc nhíu mày, cảm giác không thích hợp.\n" +
            "\n" +
            "\"Ta Tạ Hải Dương là người làm ăn, bán đi bất luận cái gì vật phẩm, đều phụ trách tới cùng, ngươi cầm bảng hiệu, phàm là gặp được địch nhân, đem này thẻ bài lấy ra, đối phương nhất định tránh lui trên trăm năm ánh sáng, thậm chí nhát gan, được trực tiếp hù chết cũng có thể!\" Tạ Hải Dương giống như đang quay lấy ngực, truyền ra phanh phanh thanh âm, cực lực cam đoan.\n" +
            "\n" +
            "Vương Bảo Nhạc cũng lười đi suy tư quá nhiều, dù sao không cần bỏ ra tiền, hắn trọng điểm không phải này thẻ bài, mà là đối phương truyền tống cùng phá vỡ phong ấn, thế là nhẹ gật đầu, cùng Tạ Hải Dương trao đổi một chút phá vỡ phong ấn chi tiết, kết thúc truyền âm lúc, trong tay truyền âm ngọc giản quang mang lấp lánh, bộ dáng có chỗ biến hóa, cuối cùng trở thành màu trắng, vẫn là ngọc thạch, phía trên còn ra hiện một đạo ấn ký.\n" +
            "\n" +
            "Cái này ấn ký không thuộc về bất luận cái gì ngôn ngữ, nhưng chỉ cần nhìn thấy, não hải liền sẽ hiện ra hai chữ bình an.\n" +
            "\n" +
            "Quan sát một chút tấm bảng này về sau, Vương Bảo Nhạc nheo lại mắt, đối với Tạ Hải Dương có thể đem truyền âm ngọc giản vô hình chuyển hóa thành cái gọi là Bình An thẻ bài thủ đoạn, rất là kinh hãi, đồng thời đáy lòng cũng không khỏi suy tư một phen.\n" +
            "\n" +
            "\"Có thể có như thế thủ đoạn, phá vỡ phong ấn không khó lắm, cần mười lăm ngày chỉ sợ chỉ là một cái lấy cớ. . . Tạ Hải Dương mục đích thực sự, hẳn là chính là muốn cho ta cái này bảng hiệu?\" Cúi đầu nhìn một chút bảng hiệu, Vương Bảo Nhạc trong mắt tinh mang lóe lên, suy tư sau đem nó thu hồi, lại nhìn một chút phía trước phong ấn, quay người nhoáng một cái bỗng nhiên rời đi.\n" +
            "\n" +
            "Đã Tạ Hải Dương nơi này tám chín phần mười mục đích là đưa cho chính mình cái này bảng hiệu, như vậy Vương Bảo Nhạc muốn nhìn một chút, đối phương đến cùng có cái gì ẩn tàng hàm nghĩa.\n" +
            "\n" +
            "\"Không phải là đào hố?\" Thân ảnh biến mất, tiếp theo một cái chớp mắt xuất hiện trên mặt đất linh văn minh một chỗ khác Tinh Thần bên trên Vương Bảo Nhạc, bước chân dừng lại, não hải nổi lên đạo này suy nghĩ.','https://cdn.truyenfull.com/medias/covers/15/15143-tam-thon-nhan-gian_cover_large.jpg',1)";
    private String SQLQuery9 = "INSERT INTO truyen VALUES (null,'XÍCH LINH','Thi thoảng lại mủi lòng thương nhớ vùng đất Tây Châu với cái nắng chói đến gay gắt, hương thảo nguyên giống một mùi rượu thật nồng. Bất giác nhớ về một câu nói đã cũ mèn chỉ còn cách gửi gắm vào sương khói:\n" +
            "\n" +
            "Tây Châu bốn mùa từng mấy bận bất ngờ ở lại gặp gỡ giai nhân...\n" +
            "\n" +
            "Trời đêm dần trở lạnh, trăm hoa rơi rụng như sương, Tây Châu trong trí nhớ vốn chỉ là những mảnh kí ức đang gục ngủ, rơi vào quên lãng. Tây Châu trong mắt giang sơn vẫn tươi đẹp như vậy, quả xa vẻ ngoài tàn khốc của chiến tranh vẫn là những hàng cây thẳng tắp, là thảo nguyên với ánh sao sáng rọi treo trên cành, với mùi hoa dại mang hương nồng ẩm thanh khiết lắm...\n" +
            "\n" +
            "Chẳng phải hôm nay là đêm trăng tròn đầu tiên của tháng mới hay sao, người Tri Viễn có tục làm lễ rước trăng vào canh ba vì họ tin rằng lúc mặt trời vừa ló rạng thì cũng là lúc vũ trụ có nguồn trăng đầy đặn nhất... Cứ thế mà Tây Châu sẽ thường dụng đêm trăng tròn này để làm ra những việc đến thiên hạ cũng chẳng thể tưởng tượng nổi, năm xưa khi giao chiến với Thành Đô, khó mà đếm nổi đã bao nhiêu sinh mệnh bị vùi lấp sau sự xa hoa của lễ hội, sau những con mắt hiền hòa và tội nghiệp lại là cả một trái tim khao khát vương quyền, trả thù đến vô tận. Rốt cuộc từ khi sinh ra, con người đã có một lòng cay nghiệt đến đáng sợ như vậy, hay đơn giản là do một mảnh số phận, một mảnh cuộc đời khác cứ ẩn sâu trong lòng không được dãi bày ra, rồi khi bị lột tẩy, con quái thú ấy lại được hồi sinh rồi quay trở về hỏi thăm, như một cố nhân lâu ngày chẳng gặp, dứt tình, cạn nghĩa...\n" +
            "\n" +
            "Ta không biết rốt cuộc mình đã bỏ quên điều gì, chỉ biết rằng thứ mình đã đánh rơi nhiều nhất chính là hồi ức, là thứ tình cảm vô vị đầy mệt nhoài. Rốt cuộc thứ hương vị ấy có cảm giác gì mà khiến ta bâng khuâng, nức nở trong tim nhiều đến thế? Ta hận lòng vì chẳng thể quên người, người lại bận lòng chẳng đoái hoài đến ta... Cuối cùng vốn dĩ chỉ mình ta đóng vai người thua cuộc, đổi chéo thiên hạ, hoa cài mái tóc...\n" +
            "\n" +
            "Tình cảm đến đây coi như cũng nguội lạnh, dặn lòng chẳng nhớ mà ngoánh lại chẳng thể quên...\n" +
            "\n" +
            "-Cô nương đang hoài niệm điều gì sao? Một giọng nói ngọt ngào như đào xuân mà trầm tư như ngọn gió đầu mùa từ phía sau cất tiếng.\n" +
            "\n" +
            "Xuyến Chi không khỏi ngạc nhiên khi người hiện ngay trước mắt mình lại là một nữ nhân chỉ hơn nàng chạc hai ba tuổi, nàng ấy có khuôn mặt dặm tròn, đôi môi ửng hồng có chút ánh đỏ, mái tóc bện cao hai hàng cuốn gọn trong dây buộc của người Tây Châu, đôi mắt trầm tư, long lanh dưới những tâm sự mãi mãi bị che giấu. Chưa tròn một khắc đôi môi ấy lại ánh lên nụ cười gượng gạo khi chính khiến vẻ mặt khó hiểu của Xuyến Chi.','https://static.8cache.com/cover/eJzLyTDW9_UrsygzLA0oNywwTi_JDzYNLDSITAuu8jc198w18PA0rAwtLi8L840qKipLjzIND8kwcE2NCEovcS6xCE4udgvL8S_1c8k0snRxywpJzy0OdbQtNzI01c0wNjICACSbH74=/xich-linh.jpg',1)";
    private String SQLQuery10 = "INSERT INTO truyen VALUES (null,'Yêu Hồ','“Đi theo ta.” – vị thủ trưởng quay lưng lại với Ân A Lạp, bước thẳng vào trong.“Ân A Lạp” – Hạ Khương nhíu mày.\n" +
            "\n" +
            "– “Cái tên này có chút quen thuộc...”Ân A Lạp liếc nhìn Hạ Khương, có lẽ hắn đã đoán ra vài phần.“Đây là hai vị kiểm dược sư giỏi nhất ở chỗ ta, tốt nhất ngươi nên mang ra thứ gì đó có ích.”“Thủ trưởng yên tâm, phiền hai vị xem giúp ta lọ đan dược này” – Ân A Lạp lôi từ trong túi ra một lọ đan dược trắng khắc ấn kí hình hồ ly nhiều đuôi, đặt lên hộp đựng trên bàn.“Đây là...” – Vị dược lão sư tiến lại gần.\n" +
            "\n" +
            "\n" +
            "– “Không thể nào.\n" +
            "\n" +
            "Ngươi lấy thứ này ở đâu?!”Vị lão sư thiếu điều lao tới nắm áo cô mà lay, hoảng hốt cùng cực.\n" +
            "\n" +
            "Ân A Lạp chỉ cười nhẹ không nói.“Chuyện gì?” – Vị thủ trưởng nắm áo lão dược sư kéo hắn đứng thẳng lên, thật mất mặt.Vị dược sư trẻ tuổi hơn xoay xoay lọ đan dược, nhìn kĩ ấn kí yêu hồ bên trên.“Ấn kí này là của Ân A Lạp, cả vùng Tây Vực không ai dám động đến hắn, chỉ cầu hắn vứt cho một thất bại luyện đan nào mà không được.\n" +
            "\n" +
            "Tên nhóc này sao lại có đan dược của hắn, mà còn là tứ phẩm đan dược.\n" +
            "\n" +
            "\n" +
            "Có thể là giả...”“Vậy thì cứ kiểm định đi.”Vị dược sư trẻ tuổi bảo nô bộc mang vào một chậu nước, rồi thả bình dược vào, mùi thảo dược thoang thoảng bốc ra, ấn kí cũng theo đó sáng lên.“Không...Không thể nào, ngươi từ đâu mà có?” – Vị dược sư trẻ tuổi sững sốt lùi lại mấy bước.“Vậy các ngươi nghĩ Ân A Lạp là người như thế nào?”Thủ trưởng nhíu mày nhìn cô, đánh giá một lượt từ trên xuống rồi ngỏ kính ngữ.“Ân A Lạp đại nhân ghé qua lại không tiếp đón nồng hậu, thất lễ rồi.” – Hắn không phải không biết, Ân A Lạp ở Tây Vực không phải là người dễ đụng.“Tẩy Linh Đan” – Cô ngả người ra ghế, phẩy phẩy chiếc quạt – “Có thể hủy đi linh căn của một tam giai đạo sĩ, cũng có thể khiến người có phế linh căn loại bỏ đi bớt những linh căn dư thừa.”Không phải Tẩy Linh Đan đã thất truyền rồi sao? Vị lão dược sư bất ngờ đứng dậy cầm lọ dược mở ra xem, quả thật là Tẩy Linh Đan.\n" +
            "\n" +
            "Vị thủ trưởng liếc nhìn hắn một cái, hắn liền đặt lọ dược xuống rồi cung kính báo.“Tẩy Linh Đan ở nước ta đã biến mất từ lâu, hiện tại xuất hiện lại, giá không dưới trăm vạn.”“Haha.\n" +
            "\n" +
            "Thủ trưởng, ông phải bán giá cao cho ta rồi.” – Ân A Lạp cười sảng khoái, nháy mắt với thủ trưởng một cái.“Tất nhiên, hạ mỗ sẽ không để công tử thất vọng.” – Vị thủ trưởng quay người dặn dò nô bộc– “Mau chuẩn bị cho Ân A Lạp đại nhân một phòng đấu giá chữ Thiên.”“Thủ trưởng khách khí rồi” – Cô đứng lên, lại phủi vạt áo một phát rồi rảo bước đi theo tên nô bộc.[Sàn đấu giá]“Tên Ân A Lạp đó lai lịch như nào, lại có thể ngồi phòng chữ Thiên.”“Được đối đãi cũng quá tốt rồi đi...”....Tiếng bàn tán lại xôn xao, Ân A Lạp ngả người chờ đợi món hàng của cô lên đấu giá.“Và món tiếp theo là Tứ phẩm linh dược: TẨY LINH ĐAN! Giá khởi điểm 50 vạn lượng”Tẩy Linh Đan! Hạ Khương đứng bật dậy, hắn đã tìm thứ này lâu lắm rồi, đệ đệ hắn được cứu rồi.“70 vạn!”“90 vạn!”“120 vạn”“150 vạn!”Hạ Khương hơi siết tay lại, nếu hắn bỏ lỡ lần này sẽ không mua được nữa...“300 vạn!”“300 vạn lần 1”“300 vạn lần 2”“Chốt giá, mời Hạ thế tử theo ta vào phòng giao dịch”Hạ Khương thở phào nhẹ nhõm, may mà không có nhiều kẻ hiểu biết về đan dược này, nếu không có 10 lần 300 vạn chắc cũng không mua nổi.Ân A Lạp thích thú nhâm nhi bánh hoa mai, lần này cô giàu to rồi, ai mà biết đan dược đó lại có giá trị như thế chứ.\n" +
            "\n" +
            "\n" +
            "Cầm theo vài cái bánh, cô đứng dậy chuẩn bị rời đi.“Món tiếp theo, nô lệ Khuyển Tộc, Bạch Khuyển, giá khởi điểm 300 vạn!”“Ổ...” – Ân A Lạp nhìn xuống dưới, một tên cún con tóc trắng.Cô tùy tiện buông thả khí tức bản thân một chút, phía dưới đột nhiên im bặt, áp lực khiến họ cảm giác nên giữ yên lặng sẽ tốt hơn, thế nhưng tên tiểu cẩu kia lại không ảnh hưởng, còn xác định được cô là người tạo ra khí thế đó.“Thú vị...” – Ân A Lạp ngồi lại xuống ghế, giơ bảng giá lên.\n" +
            "\n" +
            "– “1000 vạn lượng”“Cái gì, hắn ta điên rồi, 1000 vạn cho một con chó giữ nhà?”“Không thể tin được?!”“1000 vạn lần 1!”“1000 vạn lần 2 ““1000 vạn lần 3! Chốt giá, mời Ân A Lạp công tử theo ta vào phòng giao dịch”Phù...!Ta lại nghèo rồi huhu, Ân A Lạp xoa xoa túi đựng tiền, rời khỏi phòng chữ Thiên.\n" +
            "\n" +
            "Tên tiểu khuyển kia có sức mạnh không tầm thường đâu, có lẽ nên đánh cược một lần xem..','https://static.8cache.com/cover/eJwN0EkWY0AAANATeW0sseiFEMo8D2XjIabEmBDU6bv3f_WHjvnjgZiYOoHWUsn9ikgrTbZbkdcXoRiT1rvPwDoNSp1ylP6SI6tUp7L_aT48vFOuVwBvp4lexX4hdSYaJqKzY8COFi-P22x57W0L23UYiQW7X4mk1aY2TuPKuXoC7ftMjHEJp0zn0wYrLPXVVc3KCtDR1cxeUV0gkZKO5IoX9jBAsi8dsgTdmgfN252j_48hkgwyRH3wG8ZbbyNe39uGHNnO64jeYVzB4nJGCQ4wlfm7jxu4DX6hSYdH1S9hcvdUfabqIuRDgZfsigv1vs9r8OE2OJumhJW64-AnwT3ixSFsoBYYOROsj82Qx8aeppyxXlCJU6FN8yf5QCNbNYDwg_BHDPv40n2P22o9OHHF6Sm5R1NkiKP2xZc3la0LpGVzGO3QgYFRmU8SDitZVqTuvAnPz5DKob5PoJdHJ7ru-GVZ1H5e7qU77V42-7UeLHF1ai-CzNZKGVAkR3-UwK3vFW_P0gYtg985rfTPw180nBzITpj7aSW4kz_L045bVJtAKUz-BmUYbES85IMj_n6vD_jfEAQogczmCJg6aDkAK1kpq_LwjXnnWwpCJysjVMZJzx7fCHLQEf00l8x3bgtJVlfsPZ_Kvdmr7FfoP9ZqVGrqHzwel8RU-YKvjej74LnBB480o2JjbUjWSO_4a_P0c4j6cV180fyQhBuHTR_wVU6Qfw-a4oiOoel_N5jrEg==/yeu-ho-bach-lang-an-a-lap-huyen-the.jpg',1)";
    private String SQLQuery12= "INSERT INTO truyen VALUES (null,'Tương tư tán','Bữa cơm tối được dọn ra, có cơm rau và một bát muối vừng.\n" +
            "\n" +
            "Đây cũng coi là bữa cơm tươm tất ở cái vùng này rồi, nhà mấy đứa trẻ hồi chiều còn chẳng có cơm mà ăn.\n" +
            "\n" +
            "Vấn Thiên mời ông Lưu ăn cơm, cầm đũa bắt đầu cắm cúi ăn, chạy nhảy cả nửa ngày nên hắn khá đói, hắn ăn được nửa bát thì thấy có gì đó không bình thường.\n" +
            "\n" +
            "Ngẩng đầu nên thì thấy ông Lưu đang nhìn hắn, vẫn ánh mắt trìu mến ấy nhưng đã thêm phần cô liêu.\n" +
            "\n" +
            "Bên cạnh, Khánh Điệp cũng chỉ xều mấy hạt cơm, đôi mắt cũng đượm buồn.\n" +
            "\n" +
            "Cái không khí ảm đạm hoá ra nó vẫn ở đây.\n" +
            "\n" +
            "Dưới ánh đèn dầu hiu hắt, những thứ cảm xúc chôn giấu trong lòng cứ dần hiện ra qua từng ánh mắt cử chỉ.\n" +
            "-Con cũng không phải rời đi mãi mãi, hằng năm con sẽ về thăm hai người mà.\n" +
            "Vấn Thiên nhẹ giọng nói.\n" +
            "Ông Lưu chợt ho một tiếng rồi những tiếng ho đến dồn dập.\n" +
            "\n" +
            "Vấn Thiên cùng Khánh Điệp buông đũa toan ngồi dậy, ông Lưu liền xua tay nặng nề nói với Vấn Thiên:\n" +
            "-Thiếu chủ a, lão biết người muốn nhìn thế giới, muốn đi đó đây để kiếm tìm một lối thoát cho những kiếp người khốn khó đang vật lộn với cuộc sống ngoài kia.\n" +
            "\n" +
            "Nhưng người cũng...\n" +
            "Ông Lưu chợt dừng lại, đôi mắt già nua đã đỏ hoe lúc nào không biết, những nếp nhăn sô lại trông ông lão lại già thêm chục tuổi.\n" +
            "\n" +
            "Ông lấy tay dụi dụi mắt rồi nói tiếp:\n" +
            "-Nhưng người cũng giống lão, cũng chỉ còn bám víu với cái cõi đời này được năm bảy năm nữa.\n" +
            "\n" +
            "Vậy chi bằng ở đây với lão để lão nô bồi tiếp cho đủ cái kiếp người ảm đạm này.\n" +
            "Nước mắt ông Lưu rơi lã chã trên cái bát cơm không.\n" +
            "\n" +
            "\n" +
            "Vấn Thiên chợt đứng người rồi hắn thở nhẹ ra một hơi, hoá ra cái bí mật mà hắn giấu diếm bấy lâu nay ông Lưu chắc cũng đã biết từ lâu rồi.\n" +
            "\n" +
            "Hắn nhìn ông Lưu, cảm giác áy náy trong lòng hắn lại dâng lên.\n" +
            "Hắn cũng chẳng biết mình cố gắng trụ lại trên cái cõi đời được bao nhiêu năm nữa, hắn cũng chẳng biết khi hắn đi rồi còn có thể về đây thêm được mấy lần.\n" +
            "\n" +
            "Hắn từ bé đến bây giờ cũng chỉ ở cạnh ông Lưu cùng Khánh Điệp, bảo hắn không lưu luyến nơi đây làm sao được.\n" +
            "\n" +
            "Nhưng nếu hắn không đi thì cái vùng sơn quê nghèo đói này sẽ mãi cứ như vậy, những đứa trẻ kia sẽ lớn lên mà chẳng dám nghĩ đến ngày mai, những tên cường hào ác bá kia lại đầy đoạ những con người khốn khổ như bao năm qua.\n" +
            "\n" +
            "Hắn không làm thế được, hắn phải đi tìm ánh sáng cho chốn này.\n" +
            "Vấn Thiên lấy lại tâm tình, hắn nhẹ giọng nói với ông Lưu:\n" +
            "— QUẢNG CÁO —\n" +
            "-Con không muốn mình lại tiếp tục sống ảm đạm như vậy nữa, con không muốn mình đến lúc sắp chết rồi vẫn chẳng thể để mấy đứa trẻ học được con chữ, chẳng giúp được những sơn dân khốn khổ kia có cái ăn cái mặc.\n" +
            "\n" +
            "Con muốn tìm ánh sáng cho cái cuộc đời của con và cả của họ nữa.\n" +
            "\n" +
            "Còn nữa, con muốn gặp lại cha mẹ, con nhớ hai người!\n" +
            "Tiếng nói trầm ổn mà dõng dạc vang lên trong căn nhà nhỏ.\n" +
            "\n" +
            "Khánh Điệp mặt đơ ra, hắn mơ mơ hồ hồ biết được nhị ca của mình sắp chết, hắn định nói gì với ca ca nhưng lại chẳng nói ra lời.\n" +
            "\n" +
            "Sự im lặng chợt bao trùm lên mái tranh nhỏ, chuyến đi xa sắp tới của Vấn Thiên mang theo quá nhiều những cảm xúc, sự vấn vương và cả ly biệt nữa.\n" +
            "\n" +
            "Ông Lưu thở dài não nề rồi nói:\n" +
            "-Vậy để lão sắp xếp hành lý cho người.\n" +
            "Ông lưu đứng dậy, cái lưng còng cùng dáng đi chậm chạp mang theo những bi ai sầu khổ nặng bước vào căn phòng phía trong.\n" +
            "\n" +
            "Hai huynh đệ hắn nhìn nhau, Vấn Thiên cười ảm đạm rồi hắn cầm đũa ăn nốt bát cơm của mình.\n" +
            "\n" +
            "\n" +
            "Khánh Điệp thì ngồi lặng thinh ở đấy nhìn ca ca của mình ăn cơm.\n" +
            "Bữa cơm buồn bã cứ thế mà trôi qua.\n" +
            "\n" +
            "Vấn Thiên cất cơm cùng bát muối vừng gần như còn nguyên vào góc bếp rồi hắn bê mâm đi rửa.\n" +
            "Hắn vào phòng ngủ của ba người, hành lý của hắn đã được buộc gọn để vào góc giường từ lúc nào, ông Lưu thì đã nằm thu mình vào mép giường.\n" +
            "\n" +
            "Vấn Thiên thấy thế liền lui ra, hắn nhảy thẳng lên trên mái rơm, tìm chỗ quen thuộc, hắn lấy cái ô vẫn luôn trên lưng xuống rồi nhìn thật lâu.\n" +
            "Cái ô này từ lúc hắn sinh ra đã luôn ở bên như hình với bóng.\n" +
            "\n" +
            "Nó rất đặc biệt, thật sự nó rất đặc biệt, bởi vì mỗi khi hắn thấy mất phương hướng, cảm thấy bất lực với cái cuộc sống bất công này thì cái ô ấy luôn toả ra một thứ gì đó khiến tâm thần hắn trở nên an yên, hắn cảm giác được như có ai đó đang vỗ về mình.\n" +
            "\n" +
            "Hắn biết cái ô ấy hiện tại là bí mật lớn nhất trên người hắn, cái bệnh tình quái gở khiến hắn sắp chết kia chẳng phải là bí mật nữa rồi.\n" +
            "Vấn Thiên lắc đầu một cái, hắn nằm soài trên mái nhà mà ngắm nhìn những ánh sao đang nở rộ rực rỡ kia.\n" +
            "\n" +
            "Hắn thấy bên cạnh có động, quay sang thì thấy Khánh Điệp đang nằm cạnh.\n" +
            "\n" +
            "Hai người lặng im nhìn vườn sao chẳng thể hái, ai cũng có tâm sự của riêng mình.\n" +
            "\n" +
            "Bầu trời tối nay thật đẹp a!\n" +
            "Gió bắt đầu thổi mạnh hơn, những nhành cây yếu mềm bị cơn gió lạ giễu cợt khép nép ríu lại với nhau, gió mang thêm chút se lạnh vuốt ve lên mặt khiến con người ta trở lên khoan khoái.\n" +
            "\n" +
            "Giờ đang đầu hè, ve bắt đầu kêu, hai huynh đệ họ Lý lặng yên nhìn trời.\n" +
            "\n" +
            "Đột nhiên Khánh Điệp nói:\n" +
            "— QUẢNG CÁO —\n" +
            "-Huynh còn sống được bao lâu nữa?\n" +
            "Vấn Thiên nhìn sang đệ đệ của mình, hắn không nghĩ đệ đệ hắn lại hỏi trực tiếp như vậy.\n" +
            "\n" +
            "\n" +
            "Nhìn cái khuôn mặt trắng bóc đã có thêm vài phần kiên nghị kia khiến hắn chợt nhận ra đệ đệ của mình cũng lớn rồi.\n" +
            "\n" +
            "Có những lúc hắn đã muốn nói cho hai người biết về thời gian của mình nhưng hắn cũng chẳng nói ra được.\n" +
            "\n" +
            "Hắn biết họ không sẵn sàng, đúng hơn là hắn không sẵn sàng đệ họ lo lắng trong sự bất lực.\n" +
            "\n" +
            "Rồi họ cũng biết, và hắn cũng chẳng biết nói gì về cái chết của mình.\n" +
            "-Nhanh thì bảy năm còn muộn thì chắc là mười.\n" +
            "Vấn Thiên trả lời nhẹ nhàng như thể chuyện chẳng liên quan tới mình.\n" +
            "\n" +
            "Cũng phải thôi, việc thấy quá nhiều cái chết khiến hắn luôn tin rằng mình đã nhìn thấu cái gọi là sinh tử.\n" +
            "-Sao huynh không ở đây cùng đệ với ông Lưu?\n" +
            "-Lão đại bảo khi ta mười lăm tuổi ta có thể nhìn thế giới ngoài kia rộng lớn ra sao.\n" +
            "\n" +
            "Đệ biết không, huynh ấy còn biết trước về cái điểm dừng của bản thân ta còn sớm hơn cả ta.\n" +
            "\n" +
            "Ta cũng muốn giống như huynh ấy đi khắp đó đây để mở mang tầm mắt, xem cái thế giới ngoài kia nó có đen tối như cái cuộc sống mà ta đang thấy hay không.\n" +
            "\n" +
            "Có lẽ đấy là cách để ta không cảm thấy tiếc nuối với cuộc sống này, cũng là cách để ta có thể cứu vớt những kiếp người khốn khó ngoài kia.\n" +
            "-Nhưng...!một phàm nhân như huynh thay đổi sao được cái trật tự thối nát tồn tại suốt mấy trăm năm nay chứ.\n" +
            "\n" +
            "Việc huynh sắp làm chẳng khác gì muối bỏ biển, nó chẳng giải quyết được vấn đề gì cả.\n" +
            "\n" +
            "Những việc mà huynh sắp làm cũng chỉ là công dã tràng mà thôi.\n" +
            "Vấn Thiên nghe xong thì hơi bất ngờ.\n" +
            "\n" +
            "Hôm nay cái người đệ đệ mà hắn quen thuộc như trở thành con người khác.\n" +
            "\n" +
            "Cái người thường ngày kiệm lời như Khánh Điệp lại nói với hắn nhiều như vậy.\n" +
            "\n" +
            "Bảo những việc hắn sắp làm là vô ích ư? Đúng vậy, nó vô ích.\n" +
            "\n" +
            "Nhưng bảo hắn trơ mắt nhìn cái trật tự thối nát ấy tiếp diễn thì hắn sao làm được.\n" +
            "\n" +
            "\n" +
            "Phải có ai thay đổi cái trật tự đó chứ, không ai làm vậy hắn sẽ làm, cho dù hắn chỉ là một phàm nhân.\n" +
            "-Ta đã thấy rất nhiều thứ, những con người bất hạnh, những bất công, những thống khổ mà cái đám tự xưng là “tiên nhân” kia gieo rắc.\n" +
            "\n" +
            "Ta muốn thay đổi chúng, nhưng không đi thì thay đổi làm sao, đứng nhìn những thống khổ kia tiếp diễn rồi tự an ủi bản thân mình bằng việc cầu nguyện cho một tương lai tốt đẹp hơn sao? Ta không làm như vậy được.\n" +
            "\n" +
            "Muốn thay đổi cái trật tự thối tha ấy thì ta phải thay đổi ta trước đã.\n" +
            "— QUẢNG CÁO —\n" +
            "-Vậy cho đệ đi cùng.\n" +
            "Vấn Thiên lặng im nhìn đệ đệ của mình thật lâu rồi nói :\n" +
            "-Đệ cũng sắp đến tuổi đến tu hành ở Thanh Dương quan rồi.\n" +
            "\n" +
            "Chi bằng thay ta ở lại chăm sóc ông Lưu rồi đưa ông đi cùng với đệ.\n" +
            "\n" +
            "Ta cũng không muốn ông những tháng ngày cuối đời chẳng có ai ở bên.\n" +
            "\n" +
            "Nếu sau này ta chết mà vẫn chưa làm được cái gì, vậy hãy bảo lão đại, lão tứ, lão ngũ và cả đệ nữa, lão tam à! Hãy thay ta làm cái gì đó cho những con người khốn khổ ngoài kia, dù ít thôi cũng được.\n" +
            "\n" +
            "Thôi đệ ngủ đi, mai dậy sớm mà tu hành.\n" +
            "Vấn Thiên nói xong liền xoay người.\n" +
            "-Huynh lại không ngủ sao?\n" +
            "-Ta quen rồi.!\n" +
            "Vấn Thiên thở nhẹ một hơi, gió đêm nhẹ âu yếm lấy khuôn mặt đầy sẹo, ánh trăng dìu dịu mơn trớn cõi lòng đau thương.\n" +
            "\n" +
            "Trên cái khuôn mặt mang vài phần non nớt kia lại thêm vài phần kiên định.\n" +
            "\n" +
            "Khi con người ta tìm ra được phương hướng của cuộc đời mình thì những khó khăn, những chông gai ngoài kia lại là động lực để hắn vững bước trên cái con đường đã chọn, dù cho nó không quá dài.\n" +
            "\n" +
            "Hôm nay hắn đã nghe rất nhiều, cũng đã nói rất nhiều điều, có lẽ những điều hắn vừa nói ra chỉ là sự ảo tưởng của một kẻ phàm nhân bất lực nhìn những kẻ phàm nhân khác đang chết dần chết mòn bởi một cái trật tự thối tha.\n" +
            "Nhưng mà lão đại đã từng nói “Khi người ta ảo tưởng một điều gì đó quá nhiều và quá lâu thì những ảo tưởng ấy kỳ diệu làm sao, lại biến thành cái gọi là niềm tin”.\n" +
            "\n" +
            "Đúng vậy hắn đang bắt đầu tin tưởng chính mình có thể làm được, một chút thôi cũng được..\n" +
            "\n" +
            "\n" +
            "\n" +
            "Bạn có thể dùng phím mũi tên hoặc WASD để lùi/sang chương.\n" +
            "Truyện Full - Đọc truyện online, đọc truyện chữ, truyện hay. Website luôn cập nhật những bộ truyện mới thuộc các thể loại đặc sắc như truyện tiên hiệp, truyện kiếm hiệp, hay truyện ngôn tình một cách nhanh nhất. Hỗ trợ mọi thiết bị như di động và máy tính bảng.Contact - ToS\n" +
            "đam mỹ hài truyện xuyên nhanh ngôn tình sủng ngôn tình hài truyện teen hay ngôn tình hay truyện đam mỹ truyện ngôn tình ngôn tình hoàn ngôn tình ngược truyện kiếm hiệp hay truyện tiên hiệp hay truyện hệ thống\n" +
            "Creative Commons License\n" +
            "Website hoạt động dưới Giấy phép truy cập mở Creative Commons Attribution 4.0 International License\n" +
            "\n','https://static.8cache.com/cover/eJzLyTDWD3YJL3YxcQrL9A0t80oqsXAJLvQL860IKDUM8gzRTXU0icpwtrAIdQ7LNEstcc4vKXULNivyyDOx8DWNr8rKdgpOrjJwMy-rMAmLqHAJMTENDbQtNzI01c0wNjICAORRHm0=/tuong-tu-tan.jpg',1)";
    private String SQLQuery13 = "INSERT INTO truyen VALUES (null,'CỔ CHÂN NHÂN','\"Phương Nguyên, ngoan ngoãn giao ra Xuân Thu Thiền, ta cho ngươi chết một cách thoải mái!\"\n" +
            "\n" +
            "\"Phương lão ma, ngươi đừng hòng phản kháng, hôm nay chúng ta các phái chính đạo liên hợp lại, nhất định phải phá ma quật của ngươi. Nơi này sớm đã bày thiên la địa võng, lần này ngươi nhất định đầu thân khác chỗ!\"\n" +
            "\n" +
            "\"Phương Nguyên ngươi là đồ ma đầu chết tiệt, ngươi vì luyện thành Xuân Thu Thiền, giết ngàn vạn mạng người. Ngươi đã phạm phải tội nghiệt đầy trời, tội không thể tha, tội lỗi chất chồng!\"\n" +
            "\n" +
            "\"Ma đầu, ba trăm năm trước ngươi làm nhục ta, cướp đi tấm thân trong sạch của ta, giết sạch cả nhà ta, giết cửu tộc của ta. Từ thời khắc đó, ta hận không thể ăn thịt ngươi, uống máu ngươi! Hôm nay, ta muốn ngươi sống không bằng chết!!\"\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Phương Nguyên mặc một bộ trường bào xanh biếc rách nát, tóc tai bù xù, cả người đẫm máu, nhìn bốn phía xung quanh.\n" +
            "\n" +
            "Gió núi thổi huyết bào phất phơ, giống như chiến kì tung bay phần phật.\n" +
            "\n" +
            "Máu đỏ tươi, từ mấy trăm miệng vết thương trên người tuôn ra ngoài. Chỉ đứng trong chốc lát, dưới chân Phương Nguyên đã tích tụ một vũng máu loãng lớn.\n" +
            "\n" +
            "Quần địch bao vậy, đã sớm không có đường sống.\n" +
            "\n" +
            "Đại cục đã định, hôm nay hẳn phải chết không nghi ngờ.\n" +
            "\n" +
            "Phương Nguyên thấy rõ thế cục, nhưng mà mặc dù tử vong đến, hắn vẫn mặt không đổi sắc như trước, vẻ mặt bình thản.\n" +
            "\n" +
            "Ánh mắt hắn sâu thẳm, như một cái giếng cổ, trước sau như một, sâu không thấy đáy.\n" +
            "\n" +
            "Quần hùng chính đạo vây công hắn, không phải đường đường trưởng môn một phái tôn quý, thì cũng là thiếu niên anh hào danh chấn tứ phương. Lúc này vây chặt quanh Phương Nguyên, có gào thét, có cười lạnh, có hai mắt nheo lại hiện ra tia sáng cảnh giác, có đang che vết thương sợ hãi mà nhìn.\n" +
            "\n" +
            "Bọn họ không hề động thủ, cũng vì e ngại Phương Nguyên sắp chết phản công.\n" +
            "\n" +
            "Cứ căng thẳng như vậy mà giằng co ba canh giờ, mặt trời chiều ngả về tây, ánh sáng còn lại của mặt trời nhen nhóm bên sườn núi mà ánh chiều chiếu vào, trong một lúc sáng lên như lửa đốt.\n" +
            "\n" +
            "Phương Nguyên vẫn yên lặng như tượng, từ từ xoay người lại.\n" +
            "\n" +
            "Quần hùng ngay lập tức xôn xao một trận, đồng loạt lui về sau một khoảng lớn.\n" +
            "\n" +
            "Giờ phút này, núi đá xám trắng dưới chân Phương Nguyên, sớm đã bị máu tươi nhuộm thành đỏ sậm. Gương mặt có vẻ trắng xám vì mất máu quá nhiều mà, được ánh nắng chiều chiếu rọi, bỗng nhiên có thêm một phần hào quang rực sáng.\n" +
            "\n" +
            "Nhìn ngắm này đây khung cảnh mặt trời khuất núi xanh, Phương Nguyên cười khẽ một tiếng: \"Thanh sơn lạc nhật, thu nguyệt xuân phong. Quả nhiên sáng sớm tóc đen chiều thành tuyết trắng, thị phi thành bại quay đầu lại như không.\" Thời điểm nói lời này, trước mắt hốt nhiên hiện ra khung cảnh kiếp trước trên địa cầu.\n" +
            "\n" +
            "Hắn vốn là học sinh Hoa Hạ* trên địa cầu, cơ duyên xảo hợp xuyên qua đến thế giới này. Trăn trở nghiêng ngả ba trăm năm, tung hoành thế gian hai trăm năm, hơn năm trăm năm dài dằng dặc, nhưng cũng là trôi qua trong huy hoàng.\n" +
            "\n" +
            "(*Tên cũ của Trung Quốc)\n" +
            "\n" +
            "Rất nhiều kí ức chôn sâu dưới đáy lòng, ở thời khắc này như còn mới, sinh động như thật mà hiện về trước mắt.\n" +
            "\n" +
            "\"Cuối cùng vẫn thất bại à.\" Phương Nguyên trong lòng than thở, có hơi bùi ngùi, lại không hối hận.\n" +
            "\n" +
            "Loại kết quả này, hắn cũng sớm đoán được. Lúc trước lựa chọn, đã chuẩn bị tâm lý rồi.\n" +
            "\n" +
            "Cái gọi là ma đạo, chính là không tu thiện quả, giết người phóng hỏa. Thiên địa không dung, người trên thế gian đều là địch, thỏa sức tung hoành.\n" +
            "\n" +
            "\"Nếu như Xuân Thu Thiền vừa mới luyện thành có hiệu quả, kiếp sau vẫn muốn làm tà ma.\" Nghĩ như vậy, Phương Nguyên không kìm lòng được cất tiếng cười to.\n" +
            "\n" +
            "\"Lão ma, ngươi cười cái gì?\"\n" +
            "\n" +
            "\"Mọi người cẩn thận, ma đầu chết đến nơi còn muốn phản công!\"\n" +
            "\n" +
            "\"Mau giao ra Xuân Thu Thiền!!\"\n" +
            "\n" +
            "Quần hùng dồn ép đến, đúng lúc này, oanh một tiếng, Phương Nguyên ngang nhiên tự bạo.\n" +
            "\n" +
            "...\n" +
            "\n" +
            "Mưa xuân rả rích, lặng yên tưới mát Thanh Mao sơn.\n" +
            "\n" +
            "Đêm đã khuya, gió lạnh nhè nhẹ thổi mưa phùn lất phất.\n" +
            "\n" +
            "Thanh Mao Sơn cũng không tối om, từ sườn núi đến chân núi, hiện ra rất đốm sáng óng ánh, như là khoác một cái dải băng ánh sáng rực rỡ.\n" +
            "\n" +
            "Nơi phát ra những ánh sáng này là từng căn từng căn nhà sàn, mặc dù không thể gọi là vạn nhà lên đèn, nhưng cũng đến quy mô hàng ngàn.\n" +
            "\n" +
            "Chính là Cổ Nguyệt Sơn Trại nằm trên Thanh Mao Sơn, làm cho dãy núi mênh mông u tĩnh tăng thêm một phần hơi thở dân cư nồng đậm.\n" +
            "\n" +
            "Chính giữ nhất của Cổ Nguyệt Sơn Trại, là một tòa lầu các rực rỡ. Lúc này đang tổ chức hiến tế đại điển, vì vậy đèn đuốc càng là sáng choang, bên trong sáng ngời rực rỡ.\n" +
            "\n" +
            "\"Liệt tổ liệt tông phù hộ, hy vọng trong Khai Khiếu Đại Điển lần này có thể xuất hiện nhiều thiếu niên tư chất ưu tú hơn, trở thành hy vọng và tăng thêm máu huyết mới cho gia tộc!\" Cổ Nguyệt tộc trưởng bộ dáng trung niên, hai bên tóc mai bạc trắng, trang phục hiến tế toàn thân thuần một màu trắng trang trọng, quỳ gối trên sàn nhà màu nâu nhạt, hai tay chắp thành chữ thập trên người, hai mắt nhắm chặt thành tâm cầu nguyện.\n" +
            "\n" +
            "Đối mặt với ông ta là cái đài cao dài sơn màu đen, đài có ba tầng, thờ phụng bài vị tổ tiên. Hai bên bài vị sắp đặt lư hương đồng đỏ, hương khói lượn lờ.\n" +
            "\n" +
            "Phía sau ông ta, có hơn mười người cũng quỳ như vậy. Bọn họ mặc đồ lễ màu trắng rộng thùng thình, đều là gia lão trong gia tộc, nắm giữ các phương diện quyền hành.\n" +
            "\n" +
            "Sau khi cầu nguyện một phen, Cổ Nguyệt tộc trưởng dẫn đầu xoay người lại, hai tay trải ra ngang nhau, lòng bàn tay áp xuống sàn nhà, dập đầu. Cái trán chạm vào trên sàn nhà màu nâu, khẽ phát ra thanh âm phịch phịch.\n" +
            "\n" +
            "Các gia lão phía sau từng người đều có vẻ mặt trang nghiêm, cũng im lặng làm theo.\n" +
            "\n" +
            "Trong một lúc, trong Từ Đường dòng họ phát ra tiếng vang khẽ của cái trán va chạm vào sàn nhà.\n" +
            "\n" +
            "Xong đại điển, mọi người từ từ đứng dậy từ trên sàn nhà, lẳng lặng mà đi ra khỏi Từ Đường trang nghiêm.\n" +
            "\n" +
            "Trong hành lang, chúng gia lão lặng lẽ thở phào nhẹ nhõm, không khí có phần buông lỏng.\n" +
            "\n" +
            "Tiếng bàn luận dần dần vang lên.\n" +
            "\n" +
            "\" Thời gian thật sự là quá nhanh, nháy mắt một năm đã trôi qua.\"\n" +
            "\n" +
            "\"Khai Khiếu Đại Điển lần trước giống như mới ngày hôm qua, rõ ràng như ở trước mắt vậy.\"\n" +
            "\n" +
            "\"Ngày mai chính là Khai Khiếu Đại Điển mỗi năm một lần, không biết năm nay sẽ xuất hiện dạng máu mới gì của gia tộc đây?\"\n" +
            "\n" +
            "\"Ai, hy vọng có thiếu niên tư chất Giáp đẳng xuất hiện. Bộ tộc Cổ Nguyệt chúng ta đã ba năm không có thiên tài như như vậy xuất hiện.\"\n" +
            "\n" +
            "\"Đúng vậy, Bạch gia trại, Hùng gia trại mấy năm nay đều có nhiều thiên tài xuất hiện. Nhất là Bạch gia Bạch Ngưng Băng, thiên tư thật sự khủng bố.\"\n" +
            "\n" +
            "Không ngoại trừ ai, nói đến cái tên Bạch Ngưng Băng này, trên mặt chúng gia lão không khỏi hiện ra vẻ mặt lo âu.\n" +
            "\n" +
            "Người này thiên tư cực kỳ xuất sắc, ngắn ngủi hai năm thời gian, đã tu hành đến Cổ sư tam chuyển. Trong thế hệ thanh niên, có thể nói là đầu lĩnh đứng đầu duy nhất. Thậm chí ngay cả các thế hệ trước cũng cảm giác được áp lực từ vị nhân tài mới xuất hiện này.\n" +
            "\n" +
            "Qua thời gian, hắn tất nhiên là trụ cột của Bạch gia trại. Ít nhất cũng là cường giả một mình đảm đương một phương. Không ai hoài nghi điểm này.\n" +
            "\n" +
            "\"Nhưng mà thiếu niên tham gia Khai Khiếu Đại Điển trong năm nay cũng không phải không có hy vọng.\"\n" +
            "\n" +
            "\"Không sai, chi mạch họ Phương xuất hiện một thiếu niên thiên tài. Ba tháng có thể nói, bốn tháng có thể đi. Lúc năm tuổi có thể làm thơ, trí tuệ phi thường, tài hoa hơn người. Đáng tiếc là cha mẹ chết sớm, hiện tại được cậu mợ nuôi nấng.\"\n" +
            "\n" +
            "\"Ừ, đây là có trí tuệ sớm, hơn nữa hướng chí lớn. Mấy năm nay hắn sáng tác \"Tương kính tửu\", \"Vịnh mai\", còn có \"Giang thành tử\", ta đã nghe qua, thật sự là thiên tài!\"\n" +
            "\n" +
            "Cổ Nguyệt tộc trưởng là người cuối cùng đi ra khỏi Từ Đường tổ tông, chậm rãi đóng cửa lại, liền nghe được tiếng các gia lão bàn luận trong hành lang.\n" +
            "\n" +
            "Trong một lúc chỉ biết, các gia lão lúc này bàn luận về một vị thiếu niên gọi là Cổ Nguyệt Phương Nguyên.\n" +
            "\n" +
            "Làm người đứng đầu một tộc, đối với việc xuất hiện đệ tử ưu tú tự nhiên sẽ chú ý. Mà Cổ Nguyệt Phương Nguyên đúng là một vị chói mắt xuất sắc nhất trong lớp tiểu bối.\n" +
            "\n" +
            "Mà kinh nghiệm cho thấy, thườn là người thiên phú dị bẩm từ nhỏ gặp là không quên được, hoặc là sức lực lớn như người trưởng thành v.v.. cũng đều có tư chất tu hành ưu tú.\n" +
            "\n" +
            "\"Nếu người này kiểm tra ra tư chất Giáp đẳng, đào tạo thật tốt, cũng không hẳn không thể chống lại Bạch Ngưng Băng. Cho dù là tư chất Ất đẳng, ngày sau chắc chắn cũng có thể một mình đảm đương một phương, trở thành một lá cờ đầu của bộ tộc Cổ Nguyệt. Nhưng mà hắn sớm thông minh như vậy, tư chất Ất đẳng chắc là không lớn, vô cùng có khả năng chính là Giáp đẳng.\" Ý niệm này vừa sinh ra, khóe miệng tộc trưởng Cổ Nguyệt không khỏi mà hơi nhếch lên, hiện ra một nụ cười mỉm.\n" +
            "\n" +
            "Ngay lúc đó, ho khan một tiếng, nói với các gia lão: \"Các vị, thời gian không còn sớm, vì đại điển ngày mai suông sẻ, đêm nay xin hãy nghỉ ngơi thật tốt, điều dưỡng tinh thần.\"\n" +
            "\n" +
            "Các gia lão nghe xong lời này, đều nao nao. Trong ánh mắt nhìn nhau cũng ẩn giấu một tia cảnh giác.\n" +
            "\n" +
            "Tộc trưởng nói lời này rất kín đáo, nhưng tất cả mọi người hiểu rõ ý.\n" +
            "\n" +
            "Hàng năm vì tranh đoạt những hậu bối thiên tài này, giữa các gia lão cũng là tranh đoạt lẫn nhau đến mặt đỏ tai hồng, sứt đầu mẻ trán.\n" +
            "\n" +
            "Nên phải nghỉ ngơi dưỡng sức thật tốt, đợi ngày mai, cho một phen tranh đoạt kia.\n" +
            "\n" +
            "Nhất là Cổ Nguyệt Phương Nguyên kia, có khả năng là tư chất Giáp đẳng vô cùng lớn. Hơn nữa, cha mẹ của hắn đã qua đời, là một trong hai cô nhi còn sót lại của chi mạch họ Phương. Nếu có thể thu vào trong một mạch, đào tạo thật tốt, đảm bảo chi mạch của mình một trăm năm hưng thịnh không suy!\n" +
            "\n" +
            "\"Chẳng qua, cảnh báo trước một câu. Tranh đoạt phải đường đường chính chính tranh đoạt, không thể sử dụng âm mưu thủ đoạn, tổn hại đoàn kết gia tộc. Các vị gia lão xin hãy nhớ kĩ trong lòng!\" Giọng nói tộc trưởng nghiêm túc nhắn nhủ.\n" +
            "\n" +
            "\"Không dám. Không dám.\"\n" +
            "\n" +
            "\"Nhất định nhớ kĩ trong lòng.\"\n" +
            "\n" +
            "\"Phải cáo từ rồi, tộc trưởng đại nhân xin dừng bước.\"\n" +
            "\n" +
            "Các gia lão lòng đầy tâm tư, từng người một tản đi.\n" +
            "\n" +
            "Không lâu sau, trên hành lang đã vắng vẻ. Mưa xuân gió tạt xuyên qua cửa sổ thổi sang đây, tộc trưởng nhẹ bước đi, đi đến trước cửa sổ.\n" +
            "\n" +
            "Ngay lập tức, đầy miệng là không khí tươi mát ẩm ướt của núi rừng, thấm vào ruột gan.\n" +
            "\n" +
            "Đây là tầng ba của lầu các, tôc trưởng phóng ánh mắt nhìn lại, hơn phân nửa Cổ Nguyệt sơn trại cũng nhìn thấy tất cả.\n" +
            "\n" +
            "Đêm khuya vào giờ này, trong trại đại đa số mọi người lại còn ánh đèn, rất khác ngày thường.\n" +
            "\n" +
            "Ngày mai chính là ngày Khai Khiếu Đại Điển, liên quan đến lợi ích bản thân mỗi người. Một loại không khí hưng phấn, căng thẳng bao phủ trái tim của tộc nhân, tất nhiên là rất nhiều người ngủ không yên.\n" +
            "\n" +
            "\"Đây là hy vọng tương lai của gia tộc.\" Trong mắt phản chiếu từng điểm từng điểm ánh đèn, tộc trưởng thở dài một tiếng.\n" +
            "\n" +
            "Mà lúc này, có một đôi con ngươi trong trẻo cũng như vậy, lẳng lặng mà nhìn những ánh đèn lập lòe giữa đêm khuya này, cõi lòng ôm đầy tình cảm phức tạp.\n" +
            "\n" +
            "\"Cổ Nguyệt Sơn Trại, đây là năm trăm năm trước?! Xuân Thu Thiền quả thực có tác dụng...\" Phương Nguyên ánh mắt sâu thẳm, đứng bên cạnh cửa sổ, mặc cho gió mưa đập vào trên người.\n" +
            "\n" +
            "Tác dụng của Xuân Thu Thiền, chính là nghịch chuyển thời gian. Bài danh trong Thập đại kì cổ, có thể xếp tên thứ bảy, tự nhiên không thể coi thường.\n" +
            "\n" +
            "Nói ngắn gọn, chính là sống lại.\n" +
            "\n" +
            "\"Lợi dụng Xuân Thu Thiền sống lại, về năm trăm năm trước!\" Phương Nguyên vươn tay, ánh mắt bình tĩnh nhìn bàn tay trẻ tuổi non nớt có phần tái nhợt của mình, sau đó từ từ nắm chặt, cố sức cảm nhận được phần chân thật này.\n" +
            "\n" +
            "Bên tai là tiếng mưa phùn đập vào trên cửa sổ, hắn từ từ nhắm mắt lại, sau một lúc lâu mới mở mắt ra, thở dài một hơi: \"Từng trải năm trăm năm, giống như là giấc mộng.\"\n" +
            "\n" +
            "Nhưng hắn lại biết rõ, đây cũng không phải là mộng.','https://static.8cache.com/cover/eJwNz0cSokAAAMAXTS1JwmEPIEFJShS4UMAAQxrJwdfv9g-6R_QfRrNlOlM9EUZymmpSA0xafd-uk9kHZEVxbquh4JZYi2CKN5S8RHLTM6gJ-KOiCIQuQSYOrNK1uIYM3pk2Lqk6L8S8-XkX73Y7FRnjsU62oFBlaOFXgGZc8yp7LkL17PR0_p0ShGiuMKExLL8d7_K-aUO2k7lScVmB32FAn0UN3Mp9hQbsH4wK0-1JKaKNxbY1Wx9ub5sLKIK_B4TjickdNiXTN0y7Jr38KVQByvp0lt9Aij2X8oRHu_jVqjVsO6Wux8N62PFJi6Hnu7ijO-xrR_f_skwlQiXXvvou1gxeMwAhAScO4tvihJsthF2rKPrcDZoLAmJtHemMJnR2giJLDkbxzNUG6FwrBkNvfPec5CLdyK39AYIag0GUn-BNmUnBJZR9ILj3VgzTfRwdHR3l9CvqgHDLn5V5bLtgcprJaIETw7M2RsAWL_Mz3gjmwQNdg6Gbkc5uWNMk8XzZqve6XGWaIE6eA-Pq178t5SRqZanZTqtSjphxE7XIvPzNS2wkDX6fjQMDMhSJREHhsPDXjE-6Fe7OOtZmap2piOOHfgO0IDBf_XER2XEK7Unkt5dVyqcsjl9oJdKxuHITalfNRq_AJgPHHMx4w7otMFF8KbpBEdBXm73XDnv4cIyUvyvpIcOeYT8uucBKpJ_sjSrzOLkcriIEe7gU8ZwbNwv-HhR5A4imqH81ROkG/co-chan-nhan.jpg',6)";
    private String SQLQuery14 = "INSERT INTO truyen VALUES (90,'NHẤT NIỆM VĨNH HẰNG','Mạo Nhi Sơn là một ngọn núi ở bên trong Đông Lâm sơn mạch. Ở dưới núi có một thôn làng, dân phong ở đây thuần phác, thường cày ruộng mà sống, đoạn tuyệt với thế giới bên ngoài.\n" +
            "\n" +
            "Một buổi sáng sớm...\n" +
            "\n" +
            "Ở trước cổng chính của thôn trang, toàn bộ hương thân trong thôn đang đứng tiễn đưa một thiếu niên chừng mười lăm mười sáu tuổi. Thiếu niên này trông gầy yếu nhưng trắng trẻo sạch sẽ, thoạt nhìn rất là nhu thuận. Y phục trên người hắn chỉ là một bộ thanh sam bình thường nhưng đã bị phai màu trở thành màu trắng, hai mắt toát lên vẻ lanh lợi, trong sáng.\n" +
            "\n" +
            "Hắn tên là Bạch Tiểu Thuần.\n" +
            "\n" +
            "“Các hương thân phụ lão, ta phải đi tu tiên rồi, nhưng ta không nỡ xa các ngươi”. Vẻ mặt thiếu niên tràn ngập vẻ không nỡ, bộ dáng của hắn vốn nhu thuận, lúc này thoạt nhìn lại càng trở nên chất phác.\n" +
            "\n" +
            "Các vị hương thân quay mặt nhìn nhau, cũng làm ra vẻ không nỡ rời xa hắn.\n" +
            "\n" +
            "“Tiểu Thuần, cha mẹ ngươi mất sớm. Ngươi là... một đứa trẻ ngoan!!! Chẳng lẽ ngươi không muốn trường sinh? Trở thành tiên nhân là có thể trường sinh, có thể sống rất lâu. Đi thôi! Chim ưng con lớn lên, sẽ có một ngày cũng phải bay đi.” Một lão giả tóc hoa râm ở trong đám người bước ra, lúc nói đến ba chữ “đứa trẻ ngoan” thì giọng nói có chút ngập ngừng.\n" +
            "\n" +
            "“Ở bên ngoài, gặp bất cứ chuyện gì ngươi đều phải kiên trì. Ra khỏi thôn rồi thì cũng đừng quay lại, bởi vì con đường của ngươi là ở phía trước!” Lão nhân hiền lành vỗ vỗ bả vai của thiếu niên.\n" +
            "\n" +
            "“Trường sinh...”. Thân hình của thiếu niên rung lên. Hắn mạnh mẽ đứng dậy, ánh mắt kiên định.\n" +
            "\n" +
            "Trong sự cổ vũ của lão giả này cùng với tất cả thôn dân có mặt, hắn nhẹ gật đầu mấy cái, liếc nhìn mọi người thật kỹ rồi quay người bước nhanh ra khỏi thôn.\n" +
            "\n" +
            "Thấy thân ảnh của thiếu niên đã đi xa, mọi người trong thôn lập tức trở nên kích động. Vẻ lưu luyến trong mắt bị nỗi vui sướng thay thế. Lão giả mặt mũi tràn đầy hiền lành lúc trước giờ cũng đang run rẩy, nước mắt chảy thành dòng.\n" +
            "\n" +
            "“Trời xanh có mắt, cái tên Bạch Thử Lang này, rốt cuộc cũng đi... Cuối cũng đã đi rồi! Là ai nói cho hắn biết đã nhìn thấy tiên nhân ở gần đây? Ngươi đã vì thôn mà lập được đại công đấy!\"\n" +
            "\n" +
            "“Tên Bạch Thử Lang này rốt cuộc đã chịu đi rồi. Đáng thương cho mấy con gà nhà ta! Chỉ vì nó sợ gà gáy sáng mà không biết đã dùng cách gì xui khiến một đám hài tử đi bắt gà, đem gà trong cả thôn ra ăn sạch sẽ...”\n" +
            "\n" +
            "“Hôm nay, năm mới đến rồi!” Âm thanh hoan hô, phấn khởi vang khắp thôn nhỏ. Thậm chí có người còn lấy ra cả chiêng trống, đánh lên rất là cao hứng.\n" +
            "\n" +
            "Bên ngoài thôn, Bạch Tiểu Thuần còn chưa đi xa lắm. Hắn chợt nghe thấy âm thanh khua chiêng gõ trống từ trong thôn truyền ra, còn có cả tiếng hoan hô vang dậy. Hắn dừng lại, vẻ mặt có chút cổ quái, sau đó ho lên một tiếng, nương theo tiếng chiêng trống truyền tới, theo đường núi đi lên Mạo Nhi Sơn.\n" +
            "\n" +
            "Ngọn Mạo Nhi Sơn này mặc dù không cao nhưng lại có nhiều bụi cỏ dại. Giờ là sáng sớm mà không gian vẫn tối đen, bốn bề yên tĩnh.\n" +
            "\n" +
            "“Nghe Nhị Cẩu nói, mấy ngày hôm trước, lúc hắn bị một con lợn rừng đuổi theo tới chỗ này thì nhìn thấy trên bầu trời có tiên nhân bay qua…” Bạch Tiểu Thuần đi ở trên sơn đạo, trái tim đang nhảy lên thình thịch. Bỗng nhiên từ mé rừng truyền tới từng âm thanh rào rào giống như tiếng lợn rừng đang chạy. Âm thanh đến bất chợt khiến Bạch Tiểu Thuần vốn đã khẩn trương, lo lắng cảm thấy lạnh dọc cả sống lưng.\n" +
            "\n" +
            "“Ai? Ai ở đó!” Tay phải hắn vội lấy từ trong bọc hành lý ra bốn cây búa, sáu lưỡi rìu. Chưa hết lo lắng, hắn lại lấy từ trong ngực ra một cây nhang màu đen, cầm chặt trong tay.\n" +
            "\n" +
            "“Đừng đến đây, ngàn vạn lần đừng đến đây. Ta có búa, ta có rìu, nhang trong tay ta còn có thể triệu hoán thiên lôi, có thể dẫn tiên nhân hàng lâm. Ngươi dám đi ra, ta liền đánh chết ngươi!” Bạch Tiểu Thuần vừa run vừa hô to, kẹp chặt những thứ vũ khí kia, tranh thủ thời gian chạy theo đường núi. Dọc đường, những tiếng lách cách vang lên loạn hưởng, búa, đao bổ củi rơi xuống đầy đất.\n" +
            "\n" +
            "Chắc là hắn đã quá lo lắng, vì những tiếng rào rào rất nhanh biến mất, sau đó cũng không thấy có dã thú nào chạy đến. Sắc mặt của hắn tái nhợt. Hắn lau mồ hôi lạnh, trong đầu đã có ý buông tha không tiếp tục lên núi nữa. Nhưng rồi hắn nghĩ tới cây nhang mình đang cầm trong tay, cây nhang của cha mẹ trước khi qua đời lưu lại cho hắn.\n" +
            "\n" +
            "Nghe nói là do tổ tiên hắn khi xưa đã tình cờ cứu giúp một vị tiên nhân bị rơi xuống. Trước khi rời đi, vị tiên nhân đã để lại cây nhang này để báo đáp, còn nói sẽ nhận một người có huyết mạch Bạch gia làm đệ tử. Chỉ cần đốt nó lên là tiên nhân sẽ đến.\n" +
            "\n" +
            "Trước đây, cây nhang này đã từng được hắn đốt lên hơn mười lần rồi nhưng cuối cùng vẫn không thấy vị tiên nhân kia đến. Điều này làm cho Bạch Tiểu Thuần bắt đầu hoài nghi vị tiên nhân kia có đến thật hay không. Hôm nay, hắn quyết định thử thêm một lần là bởi cây nhang này cũng không còn nhiều lắm, lại nghe người trong thôn nói cách đây vài ngày đã nhìn thấy có tiên nhân bay qua chỗ này.\n" +
            "\n" +
            "Hắn leo lên núi vì biết đâu, ở gần thêm một chút thì tiên nhân sẽ nhận ra cũng không chừng.\n" +
            "\n" +
            "Sau một lúc do dự, Bạch Tiểu Thuần lại cắn răng tiếp tục. Cũng may là ngọn núi này cũng không cao, chẳng bao lâu sau hắn đã lên đến đỉnh núi, há miệng thở phì phò. Đứng ở trên đó, hắn quay nhìn thôn trang hiện lên thấp thoáng dưới chân núi, thần sắc có chút cảm khái rồi cúi đầu nhìn đoạn hương đen chỉ còn bằng móng tay ở trong tay.\n" +
            "\n" +
            "“Ba năm rồi... Cha mẹ phù hộ cho ta, lần này nhất định phải thành công!” Bạch Tiểu Thuần hít thở sâu, cẩn thận đem hương đốt lên. Gió lớn nổi lên bốn phía, bầu trời kéo mây đen dầy đặc. Từng tia chớp lóe lên sáng lòa, sấm nổ ầm ầm bên tai Bạch Tiểu Thuần.\n" +
            "\n" +
            "Âm thanh vang dội làm cho thân hình của Bạch Tiểu Thuần run lên, hắn có cảm giác như lúc nào cũng có thể bị sét đánh chết. Trong một giây lát, hắn đã muốn phun nước miếng dập tắt cây nhang nhưng lại dằn lại vì không cam lòng.\n" +
            "\n" +
            "“Ba năm rồi, ta đã đốt cây nhang này mười hai lần. Đây là lần thứ mười ba, lần này nhất định phải làm được. Tiểu Thuần ta không sợ, chắc sẽ không bị đánh chết đâu...”. Bạch Tiểu Thuần nhớ tới kinh nghiệm ba năm qua, không tính lần này, mười hai lần trước hắn đốt cây nhang thì mỗi lần đều có sấm chớp nổi lên như thế này, mà tiên nhân thì không thấy đến. Hắn vốn sợ chết, mỗi lần sấm chớp nổi lên là đều phun nước miếng dập tắt. Nhắc tới cũng kỳ, cây nhang này nhìn như bất phàm, nhưng lúc hắn phun nước vào là nó tắt ngay.\n" +
            "\n" +
            "Trong lúc Bạch Tiểu Thuần còn đang hãi hùng khiếp vía, chật vật chờ đợi trong tiếng sấm thì ở bầu trời cách đó không xa có một đạo trường hồng đang gào thét, bay đến rất nhanh.\n" +
            "\n" +
            "Trong đạo trường hồng này là một nam nhân trung tuổi. Nam tử này mặc y phục hoa lệ, dáng vẻ tiên phong đạo cốt nhưng thần sắc lại như phong trần mỏi mệt. Thậm chí, nếu nhìn kỹ thì có thể thấy hắn đang thực sự rất mệt mỏi.\n" +
            "\n" +
            "“Ta rất muốn nhìn xem, rốt cuộc ngươi là cái dạng gì mà đốt một cây nhang suốt ba năm qua!”\n" +
            "\n" +
            "Vừa nghĩ đến những gì mình đã trải qua trong ba năm vừa rồi, nam tử này liền nổi giận.\n" +
            "\n" +
            "Ba năm trước, y phát giác có người đốt cây nhang mà mình đã cho đi lúc vẫn còn ở Ngưng Khí kỳ. Nhớ tới đoạn nhân tình ở chốn phàm trần năm đó y vội vàng bay tới.\n" +
            "\n" +
            "Lần đó, theo tính toán của y thì rất nhanh sẽ tìm tới nhưng y lại không ngờ rằng, vừa mới nhận thấy mùi hương, còn chưa đi được bao xa thì cái khí tức kia đã biến mất trong nháy mắt, cắt đứt mối liên hệ. Nếu chỉ là một lần thì cũng thôi, nhưng trong ba năm qua, khí tức kia xuất hiện tới hơn mười lần làm cho y tìm kiếm nhiều lần mà lần nào cũng bị gián đoạn. Cứ tới tới lui lui như vậy, giằng co suốt ba năm...\n" +
            "\n" +
            "Giờ phút này y đã thấy ngọn Mạo Nhi Sơn ở xa xa, thấy Bạch Tiểu Thuần đang đứng trên đỉnh núi. Trong chớp mắt y đã bay tới đỉnh núi, sau đó vung tay, đem que hương không còn nhiều lắm kia dập tắt.\n" +
            "\n" +
            "Tiếng sấm liền im bặt. Bạch Tiểu Thuần sửng sốt, hắn ngẩng đầu nhìn vị trung niên đang đứng bên cạnh mình.\n" +
            "\n" +
            "“Tiên nhân?” Bạch Tiểu Thuần e dè hỏi bằng giọng nói có vẻ không chắc chắn, lại lén lút với lấy một cây búa ở sau lưng.\n" +
            "\n" +
            "“Bổn tọa là Lý Thanh Hậu. Ngươi là hậu nhân của Bạch gia?” Ánh mắt của tu sĩ trung niên như điện, không để ý tới cây búa ở sau lưng Bạch Tiểu Thuần, mà bắt đầu đánh giá một phen. Y thấy kẻ trước mắt này lông mày xanh, đôi mắt đẹp, lờ mờ tương tự với cố nhân năm đó, tư chất cũng không tệ, vẻ phiền muộn ở trong đáy lòng cũng bớt đi một ít.\n" +
            "\n" +
            "“Vãn bối đúng là hậu nhân của Bạch gia, tên là Bạch Tiểu Thuần.” Bạch Tiểu Thuần mở mắt nhìn rồi nhỏ giọng đáp. Tuy trong lòng hắn có chút sợ hãi, nhưng vẫn đứng thẳng.\n" +
            "\n" +
            "“Ta hỏi ngươi, châm một cây nhang thôi, vì sao lại châm những ba năm!” Tu sĩ trung niên này nhàn nhạt mở miệng, hỏi tới vấn đề mà trong suốt ba năm qua y rất muốn biết.\n" +
            "\n" +
            "Bạch Tiểu Thuần nghe thấy câu hỏi, đầu óc nhanh chóng chuyển động, sau đó làm ra bộ phiền muộn nhìn xuống thôn trang xa xa ở dưới chân núi.\n" +
            "\n" +
            "“Vãn bối là một người trọng tình trọng nghĩa, không nỡ bỏ những hương thân kia. Mỗi lần ta đốt hương, bọn hắn đều không nỡ để ta rời đi. Hôm nay bọn hắn bởi vì ta rời đi mà vẫn còn bi thương đây này.”\n" +
            "\n" +
            "Tu sĩ trung niên sững sờ. Cái nguyên do này lúc trước y không nghĩ tới, vẻ phiền muộn trong mắt đã mất đi thêm một ít nữa. Từ lời nói mà xem xét thì bản tính kẻ này cũng không tệ lắm. Nhưng khi y hướng ánh nhìn về phía dưới thôn, dùng thần thức đảo qua, nghe được tiếng khua chiêng gõ trống cùng với những câu hoan hô vì Bạch Thử Lang đã rời đi thì sắc mặt lại trở nên khó coi. Y cảm thấy đau đầu. Kẻ trước mắt này nhìn bề ngoài thì nhu thuận chất phác, cả người lẫn vật đều vô hại nhưng trong lòng lại chứa đầy những ý nghĩ xấu xa kỳ quái.\n" +
            "\n" +
            "“Nói thật!” tu sĩ trung niên vừa trừng mắt, vừa quát lên như tiếng sấm làm Bạch Tiểu Thuần giật mình, sợ hãi tới mức thân thể run lên.\n" +
            "\n" +
            "“Việc ấy cũng không trách được ta a. Cái cây nhang gì đó của ngươi, mỗi lần ta đốt lên đều kéo theo sấm sét, nhiều lần thiếu chút nữa là đánh chết ta rồi. Ta tránh thoát mười ba lần là đã rất không dễ dàng rồi.” Bạch Tiểu Thuần ra vẻ đáng thương nói.\n" +
            "\n" +
            "Tu sĩ trung niên nhìn Bạch Tiểu Thuần, im lặng một lúc.\n" +
            "\n" +
            "“Ngươi đã sợ như vậy, vì sao còn dám đi đốt nhang tới hơn mười lần?“ Tu sĩ trung niên chậm rãi nói.\n" +
            "\n" +
            "\"Ta sợ chết! Không phải tu tiên là có thể trường sinh sao? Ta muốn trường sinh a!” Bạch Tiểu Thuần ủy khuất nói.\n" +
            "\n" +
            "Tu sĩ trung niên lại im lặng. Y cảm thấy chấp niệm của kẻ này cũng đáng khen, cứ ném tới môn phái ma luyện một phen xem sao, biết đâu tính tình lại có thể thay đổi ít nhiều. Vì vậy sau khi suy nghĩ một chút, y liền hất tay áo quấn quanh Bạch Tiểu Thuần rồi hóa thành một đạo cầu vồng bay thẳng về phía chân trời.\n" +
            "\n" +
            "”Đi cùng ta.”\n" +
            "\n" +
            "”Đi đâu? Bay quá cao rồi...” Bạch Tiểu Thuần thấy mình đang bay trên trời, phía dưới là vực sâu vạn trượng thì sắc mặt nó tái nhợt, quăng búa ra, gắt gao ôm chặt lấy đùi của vị tiên nhân.\n" +
            "\n" +
            "Tu sĩ trung niên nhìn xuống chân của mình, bất đắc dĩ nói.','https://static.8cache.com/cover/o/eJzLyTDW1zUxD3A1ck4zdi_N1w-r9MgyD0sxDQz11HeEAj_dbP1A14jQ8MIyn2J3zxzDZE-XPGf38CqLZDc3f5Oi-KKAgnJn53z9ciNDU90MYyMjAHsxGlc=/nhat-niem-vinh-hang.jpg',1)";
    private String SQLQuery15 = "INSERT INTO truyen VALUES (null,'Thiên La','Bên ngoài phong linh của Thương Vân thành, Lâm Phong trừng mắt nhìn con hoàng cấp sơ giai thực thi thú như cảnh báo nó chỉ cần tiến thêm một bước thì cả hai thề không đội trời chung.\n" +
            "\n" +
            "- Kỳ lạ, thực thi thú ngày thường khôn như quỷ sao hôm nay ngu như heo vậy?Nếu là ngày thường chắc chắn Lâm Phong sẽ rất vui vì hắn là người đã đặt xác một con lợn ở đây để dụ thực thi thú nhưng hôm nay lại có một vị khách không mời mà tới.\n" +
            "\n" +
            "Cách đó gần một dặm là tam sắc yêu xà, huyền cấp sơ giai yêu thú chính hiệu, chỉ cần một ánh mắt cũng làm Lâm Phong chết khiếp.\n" +
            "\n" +
            "Tam sắc yêu xà như chưa nhìn thấy hắn chỉ thoáng liếc nhìn thực thi thú, ánh mắt do dự chưa biết có thịt hay không.\n" +
            "\n" +
            "- Thực thi đại ca, phía sao có yêu xà đang nhìn kìa.\n" +
            "\n" +
            "Lâm Phong nhỏ giọng nhắc nhở nhưng không có hiệu quả vì yêu thú và nhân tộc không có tiếng nói chung, hết cách hắn đành phải đổi giọng.\n" +
            "\n" +
            "- Gâu… gâu… cái gì vậy, lạnh quá.\n" +
            "\n" +
            "Đột nhiên một luồn hàn khí bay qua đầu Lâm Phong phóng thẳng tới chỗ yêu xà, vừa chớp mắt một cái thì yêu xà đã bị đóng thành một khối băng, chắc là teo luôn rồi.\n" +
            "\n" +
            "\n" +
            "Một bóng trắng lướt tới chỗ tam sắc yêu xà sao đó lướt đi cùng với yêu xà biến mất như chưa từng xuất hiện.\n" +
            "\n" +
            "- Ngự khí phi hành, ít nhất cũng là tu sĩ tứ cấp.\n" +
            "\n" +
            "Lâm Phong ngẫn người một lúc liền xách đao xong về phía thực thi thú đang hấp hối.\n" +
            "\n" +
            "- Ăn một đao của lão tử.\n" +
            "\n" +
            "Thương Vân thành là một trong vô số thành nhỏ của Vô Cực thánh cung do Thiết Sơn môn cai quản, trong thành lúc nào cũng có hơn vạn tu sĩ cùng vài chục vạn dân thường.\n" +
            "\n" +
            "Sao khi giết được một con thực thi thú, Lâm Phong không còn tâm trạng nào đi săn, hắn đi tới khu giao dịch tự do trong thành dùng thực thi thú đổi lấy 4 khối hạ phẩm linh thạch rồi trở lại chổ của mình.\n" +
            "\n" +
            "Đúng lúc hắn đi ngang qua một cửa hàng đồ cổ thì nhìn thấy một cái cổ nhẫn màu đen, trong lòng Lâm Phong như có lửa đốt, cảm giác này chỉ khi nhìn thấy bảo vật mới xuất hiện.\n" +
            "\n" +
            "- Lão bản thứ này bán thế nào?Lão đầu nhìn thanh kiếm gãy trả lời.\n" +
            "\n" +
            "- 50 khối hạ phẩm linh thạch, không trả giá.\n" +
            "\n" +
            "- Mắc vậy sao?Lâm Phong do dự một lúc lại chỉ vào chiếc nhẫn bên cạnh.\n" +
            "\n" +
            "- Thứ này thì sao?Lão đầu nhìn bộ dáng của tiểu tử trước mặt biết ngay gặp phải tên quỷ nghèo, lão suy nghĩ một chút rồi trả lời.\n" +
            "\n" +
            "- 30 khối hạ phẩm linh thạch.\n" +
            "\n" +
            "- 20 khối hạ phẩm linh thạch, ta lấy thứ này.\n" +
            "\n" +
            "Sao một lúc trả giá, Lâm Phong dùng 30 khối hạ phẩm linh thạch để mua cổ nhẫn, đúng là một ngày thất bại.\n" +
            "\n" +
            "Căn phòng của Lâm Phong là loại thường giành cho tu sĩ, mỗi tháng chỉ cần trả 10 khối hạ phẩm linh thạch là đủ, hắn vừa tới cửa thì gặp hai tên cạnh phòng bước ra.\n" +
            "\n" +
            "- Lâm tặc sao hôm nay về sớm vậy?- Đừng nói nữa, hôm nay vận khí lão tử không được tốt, có tin lão tử cướp các ngươi không?- Hắc hắc… tiền tài bọn ta không có nhưng trinh tiết vẫn còn, ngươi có muốn không? Ha ha ha…- Các ngươi giỏi.\n" +
            "\n" +
            "Lâm Phong buồn bực bước vào phòng, hắn lấy cổ nhẫn ngắm nhìn một lúc sao đó truyền linh lực vào.\n" +
            "\n" +
            "\n" +
            "- Không lẽ là nhỏ máu nhận chủ.\n" +
            "\n" +
            "Nếu là pháp bảo bình thường thì chỉ cần truyền linh lực vào là được nhưng cũng có một số phải nhỏ máu nhận chủ.\n" +
            "\n" +
            "Lâm Phong thử nhỏ một giọt máu vào cổ nhẫn sao đó ở một bên chăm chú quan sát, nữa giờ sau.\n" +
            "\n" +
            "- Thôi bỏ mẹ, ngay cả giác quan thứ 6 của lão tử cũng mất linh, hôm nay gặp hạn rồi.\n" +
            "\n" +
            "Hắn nhìn cổ nhẫn trên bàn, thế là 30 viên hạ phẩm linh thạch, 3 tháng tiền nhà, 3 lần vào hồng tụ lâu coi như xong, càng nghĩ càng tức Lâm Phong thẳng tay ném cổ nhẫn xuống đất giẫm thêm vài cài, chửi thêm vài câu cho hả dạ.\n" +
            "\n" +
            "- Tiểu tử thúi coi chừng bị trời đánh.\n" +
            "\n" +
            "Cổ nhẫn khẽ rung lên, một luồn bạch vụ từ trong cổ nhẫn bay ra hóa thành một lão đầu lơ lững trước mặt Lâm Phong.\n" +
            "\n" +
            "Hắn ngẩn đầu nhìn bạch vụ, vẻ mặt kinh ngạc, chỉ đạp vài cái là hiển linh.\n" +
            "\n" +
            "- Không ngờ trên đời lại có kiểu pháp bảo nhận chủ như vậy, biết vậy đâu cần phải tốn một giọt máu của lão tử.\n" +
            "\n" +
            "Lão đầu như say ngủ nghe hắn nói liền tỉnh mộng.\n" +
            "\n" +
            "- Tiểu tử thúi có phải ngươi muốn bị trời đánh không?- Gì hả? liên quan gì đến ta.\n" +
            "\n" +
            "- Ngươi…Lão đầu hừ lạnh một tiếng chui lại vào, cổ nhẫn vẫn nằm im trên mặt đất như chưa từng có chuyện gì xảy ra.\n" +
            "\n" +
            "Lâm Phong nhặt cổ nhẫn lên nhìn, ánh mắt sáng rực, tuy hắn không biết thứ này có cấp bật như thế nào nhưng nhất định là bảo vật, bán đi chắc được không ít linh thạch.\n" +
            "\n" +
            "Binh khí ở Thiên La đại lục được chia làm tứ cấp và nhất thập nhị phẩm, tứ cấp bao gồm thiên, địa, huyền, hoàng mỗi cấp lại chia thành cực, thượng, trung, hạ phẩm.\n" +
            "\n" +
            "Về lý thuyết thì binh khí cấp bậc nào cũng có thể sinh ra khí linh nhưng phải thuộc hàng cực phẩm, chỉ cần có thời gian đủ lâu để hấp thu thiên địa linh khí, một khi khí linh được hình thành có thể ôn dưỡng binh khí giúp bản thể tiến cấp theo thời gian.\n" +
            "\n" +
            "- Không biết có được 1 vạn hạ phẩm linh thạch không ?- Ngươi… đồ trời đánh, ngươi có biết lão phu là ai không ?- Không phải là một khí linh sao ?- Lão phu…Cổ nhẫn im lặng một lúc sao đó bạch bào lão đầu lại xuất hiện trước mặt Lâm Phong, ánh mắt khinh bỉ nhìn hắn.\n" +
            "\n" +
            "- Lão phu quyết định thu nhận tiểu tử ngươi làm đệ tử nhưng ngươi phải nghe theo lời của lão phu.\n" +
            "\n" +
            "\n" +
            "Lão đầu nhìn vẻ mặt kinh ngạc của Lâm Phong tràn đầy hài lòng, cho dù là thiên tài tuyệt thế đứng trước mặt lão cũng phải cuối đầu.\n" +
            "\n" +
            "- Trước tiên quỳ xuống hành lễ bái sư.\n" +
            "\n" +
            "- Hả ?- Hả cái gì, lão phu không nói hai lời.\n" +
            "\n" +
            "Lâm Phong cảm giác hôm nay vẫn là ngày hạn của hắn, nếu để người ta biết khí linh trời ơi thế này thì giá cả sẽ giảm không phanh.\n" +
            "\n" +
            "- Nè lão đầu, ta nói lão nghe, đừng tưởng già là được lên mặt, bây giờ lão tạm thời ở yên trong giới chỉ, ngày mai ta sẽ đưa lão đến Vạn bảo các.\n" +
            "\n" +
            "- Đi đâu ?- Vạn bảo các, nghe nói là thương hội lớn nhất đại lục, phòng đấu giá ở đó lớn lắm, có cả mấy ngàn người, lúc đó lão muốn thu ai làm đệ tử cũng được.\n" +
            "\n" +
            "- Ngươi… ta…Bạch bào lão đầu cảm giác muốn tan rã, lão đường đường là một trong những nhân vật có số má nhất đại lục một khi chuyện lão bị đặt lên bàn đấu giá truyền đi có lẽ cả đời lão cũng không giám ló mặt ra ngoài.\n" +
            "\n" +
            "Cái cảm giác đứng trước hàng ngàn người giới thiệu về bản thân sao đó đợi người ta trả giá chẳng khác gì kỹ nữ bán thân.\n" +
            "\n" +
            "- Không được, có chết lão phu cũng không đi.\n" +
            "\n" +
            "- Phản đối vô hiệu, ta đi ngủ đây, lão còn nhiều lời thì ta sẽ lập tức đưa lão đến Vạn Bảo các.\n" +
            "\n" +
            "Bạch bào lão đầu hừ lạnh tiến vào giới chỉ, muốn lão cầu xin một tiểu tử nhỏ hơn lão mấy chục vạn tuổi đó là chuyện viễn vong.\n" +
            "\n" +
            "Sáng hôm sao, Lâm Phong rời phòng đi dạo vài vòng trong thành, bên trong Thương Vân thành thì Vạn bảo các là thương điếm lớn nhất nhưng bên ngoài lại có nhiều nơi buôn bán hơn, phần lớn là tán tu tụ tập mua bán, trao đổi vật phẩm, mỗi tháng bọn họ phải đóng cho Thiết Sơn môn một phần lợi nhuận.\n" +
            "\n" +
            "Lâm Phong đang nhàn nhã đi dạo thì nhìn thấy mấy con hắc mã lao nhanh trên đường, phía sao còn có một cái kiệu lớn được kéo theo.\n','https://static.8cache.com/cover/eJwFwdnWczoAANAnyjoExcW5KBVtquYSbqz6KGJW89P_ezcl998xfJbQ_vvjAHkJ3YZaow9yheux2yJNWE1j0b1fHgVgSlhuY_zq66tnG_CezY87xXO0VIfqtG4kv7qdsi2-lzQjWCpSaXvrylvp7SwV9IzPGneZaqdtoMmfxwU6qRTaUdh_zokeo-UJy7OGlSR8xGAMcAM8RbVWDIf7zTGDAHuZ-779av5-5oNc0ivE7xNcSfRNubgvuxE9QTeoujit8R-ylxrJT7SiHBzSOGraqGG_Xads8ct1pqihkS31L_voW545wiPvcuFu-CBXMpaqiju1XHbni_pxzt9OhAOwx95BrD-1gIlaCXEG1zhG3RmcUNUKTCGwUbZ1nhy7UOPL96jIQ8twXLp-ojgrogqDCPVLTjBZ8GgWYOiuN8a6DxZTNK41xX6GTAU3COnUTcQqoyas0SSY541Tik0mFe3tq3ilcEwlhQnkQEwp6Zh56-tze3GPy7QY0Y7Vz1xJURp_pYzKn_OiJ3MQmSzOZ56QU6yfX3JVuSvjZuvCFbi93JJVIRa-DgYTXGpI9HTMw3n8fXfN0Wrb2nOwAn72W8_17aD4nTGyith2emcnnrxXzIN5D8nAPm9z8LuHOpJcUds6JdOp05jSRvxoalTEL_QyJ-rDBtSFzMrr6_QMZD92SasqxL8ElPXEuYkbyAvPFez8FpaLQLtvXkD9VJIwyQXq_L9BVgAlB-E_BmPpgw==/thien-la.jpg',1)";
    private String SQLQuery16= "INSERT INTO truyen VALUES (null,'Đoạt thế tranh thiên','Thương Vân Sơn sương mù lượn lờ, xa xa nhìn lại tựa như con quái vật khổng lồ đen ngòm ẩn nấp sau mây.\n" +
            "\n" +
            "Tầm mắt thu gần, cây rừng cao lớn đến mấy chục trượng, năm bảy mỏm đá xiên xẹo bao lấy mép vực, lạnh sống lưng người nhìn.\n" +
            "Tiếng la hét thảm khốc một nhóm thiếu niên bị bầy Sói hoang rượt đuổi sau vài phút, nhóm sáu người chỉ còn lại một thiếu niên liều mạng chạy về phía trước hoảng sợ tột độ.\n" +
            "Gương mặt tái ngắt, vừa chạy cậu vừa ngoảnh lại phía sau, liền thấy năm đồng bạn của mình nằm bất động máu chảy đầm đìa, trên thân mỗi người hai đến ba con Sói tập trung xé xác, trong cơn hoảng loạn thiếu niên liều mạng bỏ chạy, dẫn đến mất đà rơi xuống vách núi, lúc hồi tâm nhìn lại chỉ thấy bầy sói truy đuổi phía sau đã dừng lại mép vực, đang không ngừng gầm gừ, nhe nanh tiếc nuối con mồi.\n" +
            "Thời khắc cái chết cận kề cậu dùng hết sức hét to, nhiều mảnh ký ức trong đầu thoáng hiện lên, thân thể đập mạnh xuống cành cây lớn, kế đó mọi ý thức xung quanh tối đen.\n" +
            "\n" +
            "Chỉ còn vài nhịp ý chí yếu ớt, nương theo thân thể bất động trên bãi đất đang âm ấm, lạnh ngắt dần.\n" +
            "Cùng lúc trong không trung vô tận một mảnh tàn hồn yếu ớt, linh quang ảm đạm chỉ biết buông xuôi mặc cho linh khí thiên địa bào mòn chẳng biết vì gì lại rơi trên cái xác kia, sau đó thẩm thấu tan biến.\n" +
            "\n" +
            "Sáng hôm sau lũ chim ăn xác chết tập trung đến vài chục trên thân thể kia, dùng mỏ mổ vào từng nơi bắp thịt.\n" +
            "\n" +
            "Chợt đôi mắt thiếu niên nọ mở mạnh, tuy toàn thân vẫn bất động đau nhức, hắn nhìn ánh nắng phía xa, liếc trái liếc phải, lục lọi tâm tư tìm lại ký ức.\n" +
            "Hình ảnh lờ mờ thoáng hiện, cảnh một tên thanh niên đạo bào trắng toát ngồi xếp bằng trên một tế đàn, bên ngoài là Thạch Trận, trên mỗi thạch trụ chi chít cổ văn, đỉnh trụ lập loè mấy tầng linh quang phát sáng theo nhịp chú ngữ từ miệng bạch y Đạo Nhân nọ.\n" +
            "Linh khí thập phương không ngừng hội tụ đậm đặc có thể thấy rõ bằng mắt thường, đè nén đến điểm giới hạn chuyển hóa thành cột ánh sáng chói mắt như mặt trời, đánh thẳng vào trung tâm nơi tên thanh niên ngồi.\n" +
            "Hắn nhếch miệng cười nhạt, tự hào như vừa thành công một đại sự, nhưng cũng trong khoảnh khắc đó, sau lưng Y truyền đến một cỗ sát khí rét lạnh, đại kiếm huyễn ảnh tựa phong lôi vun vút băng qua thạch trận, từ sau lưng đâm xuyên ngực hắn, yểm hậu một kiếm kia là vô số chưởng pháp, cự quyền ác ý, cấp bậc uy hiếp chỉ hơn chứ không kém.\n" +
            "Đại trận mở ra kết giới, nửa chân bước vào, khi hắn cảm giác được sát ý phía sau, cùng là lúc bản thân đang dần tiêu thất, ko nghĩ đến một kiếm kia lại giam cầm bản thể nguyên vị.\n" +
            "Mà thần hồn của hắn đã lỡ đà lao ra khỏi thân xác, chỉ kịp dùng ý thức ngoảnh lại đối mặt với những cuồng phong đang oanh kích.\n" +
            "\n" +
            "\n" +
            "Ko có bản thể phối hợp, thần hồn làm sao thi triển thần thông đối kháng, chỉ đành thản nhiên hứng chịu, kế đó một mảng trắng xoá bao phủ, hàng trăm tiếng cười hò hét có quen có lạ, đâu đó còn văng vẳng vài câu:\n" +
            "- Hàn Cổ, không ngờ ngươi cũng có ngày hôm nay..\n" +
            "- Thần Thể đao thương bất nhập? ha ha, bọn ta ngàn người trả giá thọ mệnh thi triển đánh ra.\n" +
            "\n" +
            "Đúng đúng, Xích Hà Du Sơn kiếm.\n" +
            "\n" +
            "Chính là một kiếm này năm đó ngươi vũ nhục lão tổ tộc ta.\n" +
            "- Hay cho một tiểu tử ngông cuồng, ông đây có liều cái mạng cũng phải chém nát ngươi.\n" +
            "Hắn thoáng nhớ ra chủ nhân của những giọng nói đó, là đồng bọn, tri giao, đồng môn, huynh đệ, hồng nhân trên hình thức.\n" +
            "\n" +
            "Một số hậu duệ của tộc nhân từng đối nghịch mà hắn đã tha cho mấy lần.\n" +
            "“Đáng chết” nghiến răng mắng thầm, chính mình sai sót nuôi ong tay áo, tự dẫn đến kiếp nạn diệt thân.\n" +
            "\n" +
            "không kịp cứu vãn nữa, bản thể bị giam cầm, thần hồn hứng công kích đã bị vỡ nát.\n" +
            "\n" +
            "Trong thời khắc tận cùng, hắn dùng cấm thuật mượn lực linh khí tàn tụ thi triển màn tự bạo tàn hồn che mắt, lưu ký ức trên một mảnh cực nhỏ lẩn trốn vào hư không.\n" +
            "\n" +
            "“Hàn ca, ngươi ích kỷ tự bạo tàn hồn, cam tâm tự diệt cũng không muốn để chúng ta, dụng pháp sưu hồn chiếm lấy bí mật lưu trữ của ngươi?”\n" +
            "Tàn ý thức của y tắt ngúm sau ngữ điệu nửa vui nửa buồn của nữ nhân kia.\n" +
            "\n" +
            "Lúc này những con chim ăn xác đã dọn sạch lớp vải bên ngoài, ngoảm từng miếng da người nuốt vào ừn ực.\n" +
            "\n" +
            "hắn đau đớn hét thảm, thân thể thoáng động.\n" +
            "\n" +
            "khiến lũ chim hoảng sợ vỗ cánh bay lên kêu gào âm thanh khó nghe biểu lộ bất cam.\n" +
            "\n" +
            "Hắn cũng chợt rùng mình ý thức được sự sống\n" +
            "“Ta chưa chết?”.\n" +
            "Cố vùng vẫy ngồi dậy nhưng không thể, toàn thân cứng ngắt tựa tàn phế, trừ đôi mắt động đậy, nhìn bầu trời xanh, lại có cảm giác gò bó như đang bên trong không gian nhỏ hẹp.\n" +
            "\n" +
            "Bầy kềnh kềnh ve vãn bên trên, không có ý bỏ đi, khiến ánh mắt đắng trát vô lực không khỏi dấy lên tâm tư bất mãn:\n" +
            "May mắn sống sót trước vô tận công sát của đám ma đầu kia, không lẽ thảm bại dưới móng vuốt của tiểu súc cầm này”.\n" +
            "Ngay lúc phi cầm cường hãn nhất tựa như con đầu đàn gào thét lao thẳng xuống, đồng tử hắn nở lớn trừng mạnh quật cường đáp trả, trong ánh mắt này bao gồm sát ý nồng đậm, mà khi khoảng cách chỉ còn vài thước, hung cầm bỗng rợn thân, rẽ qua một hướng khác rơi “bịch” trên phiến thạch, đồng thời không kìm được co giật như vừa đối diện một ác thần khát máu.\n" +
            "Cùng một màn này, hắn chợt nhận ra vừa rồi chính mình phát ra sát uy linh nhãn, là bóng dáng “Linh Nhãn Bí Pháp” trước kia từng dùng.\n" +
            "\n" +
            "Vận may loé lên hàng loạt tâm tư suy diễn hoàn cảnh hiện tại, phân tích tìm giải pháp.\n" +
            "\n" +
            "Mà cũng vì dưới sức tàn lực kiệt, cưỡng ép bộc phát tiềm lực quá lớn, khiến hai mắt y sưng đỏ gân máu nứt vỡ, buộc phải khép mắt lại.\n" +
            "\n" +
            "\n" +
            "Hành động này càng khiến hắn giật mình nhớ đến điều gì, nghẹn họng:\n" +
            "“Ta có nhục thể, từ lúc nào ta có nhục thể?”\n" +
            "Chính hắn cũng không biết mình đã nhập xá trùng sinh, bởi lẽ không có thời gian để nghĩ, vì vừa có ý thức liền đối mặt hiểm cảnh này.\n" +
            "\n" +
            "Tất cả nghĩ suy thoáng qua đều rất hỗn độn, chưa mang đến lý giải hoàn chỉnh, mà trước mắt quan trọng nhất vẫn là làm thế nào để sống sót vượt qua.\n" +
            "\n" +
            "Sinh cơ đang khô kiệt, tàn hồn ảm đảm đến mong manh, bản thân là thực phẩm trên bàn ăn của hung cầm.\n" +
            "Hắn liền quyết đoán dứt khoát, nắm lấy cơ hội tích tụ sinh cơ còn sót dồn nén triển khai cổ chú triệu gọi hung cầm dùng mỏ va chạm cơ thể theo các huyệt vị đã xác định trước.\n" +
            "Vốn dĩ phương pháp kích thích sinh cơ là dùng lực lên tám huyệt chính, sáu mươi tư huyệt phụ.\n" +
            "\n" +
            "với phương thức rút gọn hắn đã tỉ mỉ nghiên cứu và thường xuyên sử dụng vẫn mang lại hiệu quả cao chỉ cần mười tám điểm là đủ dù cách này khiến nhục thể rả giá hắn đã không còn cách khác tốt hơn.\n" +
            "Sau khi sinh cơ hồi hoàn, cơ thể đã lưu động được, tuy chỉ ước chừng trong mười hơi thở, hắn tiếp tục mị hoặc sai khiến cả đàn tụ lại một chỗ, lấy máu của mình vẫy lên bầy chim, miệng lẩm bầm “Cổ Chú Yêu Pháp”.\n" +
            "\n" +
            "Tay bắt ấn dẫn đạo lấy chính mình làm vốn tạo ra một tiểu trận gọi là “Hiến Tế Sinh Cơ”.\n" +
            "Trong vài khắc, huyết nhục của cả bầy hung cầm bị hút ra, hình thái như những sợi chỉ hoán nhập không khí hình thành một đám huyết hồng sương vụ bao lấy thân thể thiếu niên, hung cầm nhanh chóng cạn kiệt sinh cơ chỉ còn lại khung da ốm nhách.\n" +
            "Lượng huyết nhục kia chuyển vào thân thể Y, Y nhanh chóng nhập định thi triển công pháp căn bản bài trừ tạp chất, thở phù ra một đám lớn hắc khí.\n" +
            "Lúc trước hắn nghiên cứu sở trường của địch nhân trước khi đối đầu trong đó có yêu tộc.\n" +
            "\n" +
            "\"Hiến Tế Sinh Cơ” là một dạng tế đàn, trăm vạn yêu thú cấp thấp hy sinh hiến tế thành lực lượng cho Yêu Chủ tăng cường đại, trước kia Y xem cách tu luyện này như rác rưởi, trong một lần tình cờ mô phỏng pháp trận tương tự để tìm yếu điểm, không nghĩ chính mình hôm nay phải dùng đến để tự cứu lấy thân.\n" +
            "Hắn lại nghĩ đến những kẻ ám toán mình, một vài cái tên, kế đó ngửa mặt hét dài:\n" +
            "- Nỗi nhục hôm nay ta sẽ trả lại các ngươi gấp vạn lần.\n" +
            "\n" +
            "Sau khi phát tiết, mới nhìn đến cơ thể, bàng hoàng nhận ra thân mình là một thiếu niên còn rất xa lạ.\n" +
            "\n" +
            "Bối rối suy diễn tới lui:\n" +
            "“Ta vừa đoạt xá? Không đúng! Kí ức hỗn độn không lưu giữ hình ảnh linh hồn ta cắn nuốt linh hồn hắn chiếm thân này.”\n" +
            "“không lẽ đây là nhập xá trùng sinh.\n" +
            "\n" +
            "Cái tỉ lệ rất thấp kia!”\n" +
            "Hắn một đời nghiên cứu cổ thư, cô độc tịch mịch một đường đi riêng, thế hệ thanh niên đã đoạt nhiều danh khí xưng bá một vùng trời.\n" +
            "\n" +
            "Trong số cổ văn hắn ưa thích xem xét, có quyển tên gọi “Tiên Hiệp Đại Điển”, cũng chẳng biết vị Đại Năng nào sưu tầm soạn ra, mà bên trong lưu giữ chi tiết cuộc đời hơn vạn tiên giả nghịch thiên tu luyện từ xuất thân hành trình lẫn công pháp bọn hắn sự dụng.\n" +
            "Cũng từ trong đó, hắn học hỏi không ít kinh nghiệm, đúc kết sáng tạo ra cho mình phương thức tu luyện cực nhanh, những con át chủ bài bá đạo, một đường thần tốc đột phá.\n" +
            "Mà bên trong Cổ Thư kia cũng có vài kẻ nửa đường vấp ngã, chuyển sinh về thời niên thiếu hoặc thời điểm thuận lợi nào đó, thúc đẩy bọn hắn nghịch thiên xưng bá.\n" +
            "\n" +
            "Trước kia Y luôn cảm thấy mơ hồ về trường hợp này không mấy tin tưởng, còn thường mỉa mai:\n" +
            "\"Một kiếp nhân sinh lại có hiệp hai để bù đắp thiếu sót, điều kiện tốt đến vậy, thật sự có thể sao!”\n" +
            "Hôm nay xét chính mình vừa khớp với trường hợp kia, tự dưng thoáng vui sướng ngập tràn một hơi, nhưng lại bất mãn lẩm bẩm:\n" +
            "“Không đúng bọn hắn nhập xá chuyển sinh rất thuận lợi, một tên phế vật nào đó bị đánh chết, chí ít cũng là thiếu gia của thế lực không nhỏ, vừa đến nhập vào liền sinh cơ bừng bừng, có kẻ nhập xong thi triển lực lượng được luôn, xung quanh đều có tài nguyên thật nhiều để tu luyện.\n" +
            "\n" +
            "Như ta gặp một kẻ bị phế tương tự, còn xém bị hắn kéo theo chết thêm lần nữa”.\n" +
            "Nghĩ vậy nhăn mặt lắc đầu thở dài.\n" +
            "Nếu không phải hắn có thủ đoạn cướp đoạt sinh cơ thì đã hoàn toàn bị diệt, đám hung cầm cũng xem như là ân nhân đem đến cho hắn tia hy vọng, nhưng hắn cũng biết giờ phút này có miệng năm miệng mười bất mãn so đo gì thì cũng là qua loa cho béo miệng mà thôi, vì một đường chuyển sinh này đáng quý biết bao..','https://static.8cache.com/cover/eJzLyTDWN7QIKDXNCIxMcQ0oSgutcM8qMspIzChKDPVzzwjxiUj3K7PMqPIu8U4KNPHPiEoqCMzMMzFxNonKSM8KzivKLkjOC7EM9a4wMPRzyrOsyjWPKrctNzI01c0wNjICADlUICQ=/doat-the-tranh-thien.jpg',1)";
    private String SQLQuery17 = "INSERT INTO truyen VALUES (null,'Độc lộ','Ngô Vương mở ra đại kỷ nguyên; Đinh Tiên Hoàng nhất thống thiên hạ; Lý Thái Tổ hùng tài đại lược; Trần Hưng Đạo binh pháp vô địch; Trần Nhân Tông anh minh thần võ; Lê Thái Tổ anh hùng cái thế; Nguyễn Ức Trai tài hoa trác tuyệt; Quang Trung Hoàng Đế chấn nhiếp bát phương...\n" +
            "Không có phi thăng khi mở đầu, không có tử vong để trọng sinh, cũng không có phế vật yếu kém, một gã thanh niên Việt Nam cứ bình thường đi theo con đường của các bậc cổ nhân bước lên tinh không vô tận, tiến về một thế giới hỗn loạn đầy đặc sắc, theo đuổi những truyền kỳ bất hủ cùng năm tháng.\n" +
            "Khai sáng thần thoại bất hủ, một chữ \"Tôn\" hiệu lệnh Hồng Hoang!\n" +
            "Ngạo thị cổ kim tương lai, \"Hoàng\" Thái Cổ vạn tộc cộng tôn!\n" +
            "Chấn nhiếp chư thiên muôn đời, “Đế” đăng vị uy khắp Thượng cổ!\n" +
            "Cận cổ hiện, thiên địa suy tàn, vạn vật điêu linh, thiên kiêu của mỗi thời đại lần lượt xuất hiện tiến hành những tranh đấu khốc liệt nhất.\n" +
            "Thể chất mạnh nhất, thiên phú tuyệt luân, ngộ tính đáng sợ, tâm cảnh vô địch, cơ duyên nghịch thiên,...!Ai có thể cười đến cuối cùng?\n" +
            "Con đường vấn đỉnh, anh kiệt tranh phách\n" +
            "Đại thế hoàng kim, ai nổi ai chìm?\n" +
            "Mặc vạn đạo truy tiên, ta đăng vị Chúa Tể!\n" +
            "“Đế”, “Hoàng” hay “Tôn”?\n" +
            ".....!\n" +
            "Thiên Địa Huyền Hoàng, Vũ Trụ Hồng Hoang!\n" +
            "\n" +
            "Vũ trụ là bí ẩn lớn nhất thế gian, như thiên Tề Tục Huấn sách Hoài nam Tử đã ghi: “Bốn phương, trên dưới, gọi là Vũ; Từ xưa đến nay, gọi là Trụ”.\n" +
            "\n" +
            "Như vậy, có thể hiểu một cách đại khái, ‘Vũ’ là khái niệm chỉ không gian; ‘Trụ’ là khái niệm chỉ thời gian.\n" +
            "Không gian tuy có thực, nhưng vô định không thể cầu được.\n" +
            "\n" +
            "Thời gian tuy liên tục chuyển động, nhưng không biết ngọn nguồn của nó.\n" +
            "\n" +
            "Có thể hiểu là, vũ trụ bắt nguồn từ đâu, rộng lớn đến mức nào, không ai biết.\n" +
            "Vũ trụ mênh mông, tinh không vô ngần, rất nhiều nhà khoa học đều nhất trí rằng, Địa cầu là nơi duy nhất tồn tại sự sống, Chính phủ các nước cũng rất đồng tình.\n" +
            "\n" +
            "Còn người dân thì không nghĩ như vậy, đa số tin rằng người ngoài hành tinh đã từng đến Trái đất, họ ẩn giấu xung quanh chúng ta.\n" +
            "Thậm chí những người theo thuyết âm mưu còn đưa ra ý kiến, có thể người ngoài hành tinh đến Trái đất đã bị các siêu cường quốc bắt giữ để tiến hành nghiên cứu trong bí mật.\n" +
            "\n" +
            "\n" +
            "Hoặc táo bạo hơn, sinh vật ngoài Trái đất đang làm việc cho Chính phủ các siêu cường, chính họ là tác nhân thúc đẩy sự bùng nổ hạt nhân trong những thập kỷ qua.\n" +
            "Nhưng suy đoán, cuối cùng cũng chỉ là suy đoán.\n" +
            "\n" +
            "Sự tò mò, khát khao tìm hiểu vạn vật, khát vọng về nơi ở mới, cảm giác cô độc, lại thêm nguy cơ tận thế do sự suy thoái của Địa cầu,...!tất cả thúc đẩy nhân loại lao vào việc tìm kiếm sự sống ở ngoài kia.\n" +
            "Con người đã phóng tàu vũ trụ, thám hiểm không ít hành tinh để kiếm tìm sự sống khác, từ những nước đi đầu như Liên Xô, Hoa Kỳ đến những nước chậm hơn như Trung Hoa, Nhật Bổn..., nhưng cho tới nay, câu hỏi trên vẫn chưa có lời đáp.\n" +
            "\n" +
            "Nhưng không vì vậy mà ngăn cản được khát khao đi tìm sự sống ngoài Trái đất của những quái kiệt của ngành vũ trụ học.\n" +
            "Sự kiện nổi bật nhất trong những năm gần đây, có lẽ chính là việc con tàu “Những chân trời mới” được phóng lên không gian vào năm 2006 với mục tiêu khám phá hành tinh duy nhất chưa được khám phá trong Thái dương hệ-Diêm vương tinh.\n" +
            "Mang hình dáng của một chiếc đàn piano cỡ lớn, mặt trên gắn một chiếc đĩa ghi lại lời hỏi thăm đến vũ trụ bằng các loại ngôn ngữ trên Địa cầu, có lẽ nhiệm vụ của con tàu Những chân trời mới không chỉ đơn giản như vậy, các nhà khoa học còn muốn nhiều hơn.\n" +
            "Chín năm trôi qua, tháng 7 năm 2015, Những chân trời mới đã làm nên lịch sử khi trở thành con tàu đầu tiên của nhân loại thăm dò thành công sao Diêm vương.\n" +
            "\n" +
            "Từng bức ảnh được gửi về, từng dữ liệu được phân tích, hoàn thiện những suy đoán của các nhà khoa học về hành tinh lùn này.\n" +
            "Chỉ là, trong số những dữ liệu đó, có những hình ảnh khiến các nhà khoa học phải giật mình, rải rác trên màu đen huyền bí của sao Diêm vương là hình ảnh không ràng của những tòa phế tích...!\n" +
            "\n" +
            "Sau khi hoàn thành sứ mệnh lịch sử, con tàu Những chân trời mới rơi vào trạng thái ngủ đông, tiếp tục thực hiện tham vọng to lớn hơn của Cục Du hành vũ trụ Mỹ, tiến vào vành đai Kha-Y với mục đích thăm dò tấm lá chắn của Thái Dương hệ này.\n" +
            "Hay thậm chí mang khát khao xa vời hơn, tìm kiếm kẻ lang thang bí ẩn nhất của Thái dương hệ đang lẩn khuất đâu đó trong vành đai Kha Y, đại hành tinh được biết đến với tên gọi: Hành tinh thứ chín!\n" +
            "Trong hắc ám và băng lãnh của Vụ trụ, điểm một vài tinh cầu, trông như những viên Kim Cương trong suốt, khảm trên một tấm màn màu đen.\n" +
            "Nhưng chân trời mới tuy rằng đang phi hành cực nhanh, thế nhưng trong u lãnh cùng vô ngần của vũ trụ nó chỉ như những con sâu, con kiến nho nhỏ đang chậm rãi bò trên mặt đất đen tối.\n" +
            "Quá trình ngủ đông kéo dài cũng là lúc các nhà khoa học tích cực vật lộn với đống tín hiệu được gửi về mỗi tuần, từ đó thiết lập nên hành trình du hành tới một số thiên thể trôi nổi trong vành đai Kha Y, hạn chế các rủi ro trong quá trình tiếp cận các thiên thể xuống mức thấp nhất.\n" +
            "Thế nhưng, dù thiết lập được lịch trình cẩn thận đến mức nào thì trong tinh không tràn ngập vô vàn hiểm nguy, mọi thứ cũng đều có thể xảy ra.\n" +
            "\n" +
            "Cũng như phần lớn các tàu thăm dò vũ trụ khác, con tàu Những chân trời mới hoặc đã phát sinh trục trặc, hoặc bị gián đoạn tín hiệu liên lạc vĩnh viễn biến mất trong vũ trụ cô quạnh.\n" +
            "Chỉ là, trước khi mọi liên lạc bị cắt đứt, Những chân trời mới đã kịp gửi về Cục du hành vũ trụ một số liệu thần bí.\n" +
            "\n" +
            "Sau bao nhiêu khó khăn để phiên dịch, các nhà khoa học cũng thấy được một một hình ảnh không thể tưởng tượng.\n" +
            "Một hành tinh khổng lồ với một màu đen tối tăm vô tận, bằng cảm giác cũng có thể thấy được nó lớn hơn bất kỳ hành tinh nào trong Thái dương hệ, gần như hòa vào sự tối tăm bí ẩn của vành đai Kha Y.\n" +
            "Chỉ là không ai có thể tỏ ra vui mừng, bởi hình ảnh cuối cùng được gửi về, hình ảnh được chụp vô khá rõ nét, chứng tỏ con tàu đã tiếp cận rất gần với Hành tinh đen bí ẩn.\n" +
            "\n" +
            "Lặng lẽ ở một góc của hành tinh đen khổng lồ, một tòa kiến trúc đơn độc nằm đó.\n" +
            "Không hề hư vô mờ mịt như những kiến trúc chụp được ở Diêm vương tinh, dù đại bộ phận đã bị sụp đổ do sự bào mòn của tuế nguyệt, nhưng vẫn có thể khẳng định đây là kiến trúc do sinh vật tạo nên, thậm chí với những cái đầu toàn sạn của các vị tinh anh giới khoa học, có thể dễ dàng nhận ra lối kiến trúc mang đậm dấu ấn văn hóa Á Đông kia.\n" +
            "\n" +
            "Trong số các nhà vũ trụ học, có một người kinh hãi hơn cả, đó là một nhà khoa học gốc Việt.\n" +
            "\n" +
            "Ông kinh ngạc, thậm chí thấy sợ hãi, trái tim không ngừng co rút, bởi ông nhận ra phong cách kiến trúc quen thuộc kia, và bốn chữ cổ kia, tuy rất khó đọc, nhưng với một người thích nghiên cứu cổ văn, thì rất nhanh nhận ra, một cái tên không thể quen thuộc hơn với bất kỳ một người Việt nào.\n" +
            "Thần là gì? Là hiện thân của tôn giáo, của thần thoại, của văn hóa mỗi nước, là một thực thể với quyền năng thiên liêng và được cho là trường sinh bất tử.\n" +
            "Đương nhiên, ngày nay khoa học đã hoàn toàn phủ nhận sự tồn tại của Thần, của truyền thuyết, của thần thoại, hay những câu chuyện cổ tích.\n" +
            "Thử hỏi ngày nay, có mấy ai tin tưởng vào sự tồn tại của những câu chuyện cổ tích, những điều ảo diệu vượt qua khỏi quy luật tự nhiên đây?\n" +
            "Cái gọi là người ngoài hành tinh có thể tồn tại đâu đó ở ngoài kia, chứ ‘Thần’ thì không hề tồn tại.\n" +
            "\n" +
            "Nếu như ‘Thần’ có thể tồn tại trên thế gian, thì cũng chỉ xuất hiện trong sự ký thác mà tâm linh yếu đuối của con người tìm kiếm.\n" +
            "Thế nhưng lúc này đây, quan niệm và niềm tin của nhà vũ trụ học gốc Việt đang bị đả kích kịch liệt, tâm linh ông run rẩy, miệng lầm bẩm vài câu khiến những nhà khoa học khác phải ngoái lại nhìn:\n" +
            "“Dấu son hỏa tự in rồng lượn\n" +
            "Bút thảo đường văn dáng phượng bay”\n" +
            "Bốn chữ cổ được viết trên tấm biển khổng lồ...\n" +
            "...Lạc Long Thủy Phủ!.\n','https://static.8cache.com/cover/eJzLyTDW9wn3ykqL8nAMjoowTDRKDg1xKTDOdEn09CvOtix29Cw39_LV9Q_y9ylLyS4w9SsvqioICnAsjTcPDU0qL6gsLvPQjUgsyPJ30w3MCssod_QqcQu0LTcyNNXNMDYyAgAuhyAQ/doc-lo.jpg',1)";
    private String SQLQuery18 = "INSERT INTO truyen VALUES (null,'Ngã thị chí tôn','Thiên Huyền đại lục.Một đại lục vô cùng thần kỳ.Thiên Huyền đại lục, có Vô Tận Chi Sâm, không ai biết nó rộng bao nhiêu.\n" +
            "\n" +
            "Có Vô Tận Hải, không ai biết nó sâu chừng nào.\n" +
            "\n" +
            "\n" +
            "Còn có vô tận Huyền thú, vô thượng đại sơn…Thiên Huyền đại lục, càng không ai biết nó rộng bao nhiêu, lớn chừng nào.Truyền thuyết kể lại, từng có một vị Thiên địa Chúa tể phi thăng từ đây mà đi…Phương Đông Thiên Huyền đại lục, chính là vùng đất trật tự nhất.\n" +
            "\n" +
            "Nơi đây có bảy phương bá quyền, năm đại đế quốc tạo thế chân vạc.\n" +
            "\n" +
            "Mặc dù chiến loạn liên miên, nhưng bách tính cũng coi như được an cư lạc nghiệp.Đông Huyền đế quốc, Đại Nguyên đế quốc, Ngọc Đường đế quốc, Thiên Tứ đế quốc, Tử U đế quốc.Mọi chuyện, bắt đầu từ Ngọc Đường đế quốc.…Truyền thuyết cổ xưa: Cửu Tôn giáng thế bình thiên hạ, xây thiên thu vạn thế nghiệp cơ!Tinh thần chuyển động, Nhật Nguyệt luân hồi, Cửu Thiên trận ứng lực mà xuống.Cửu Thiên trận, có thể tác thành chín vị thiên tài tuyệt diễm.Chỉ cần phù hợp với điều kiện Cửu Thiên trận, liền có thể thu được truyền thừa, đạt được lực lượng huyền bí siêu tuyệt thế gian.\n" +
            "\n" +
            "Mà Cửu Tôn thành, liền có thể định được vận mệnh thiên hạ.Nói cách khác, bất kỳ quốc gia nào có được Cửu Thiên trận, lập tức có thể trở thành bá chủ đại lục.Đương nhiên, hết thảy đều chỉ là truyền thuyết.Cho đến một ngày…Vạn dặm không mây, ánh dương chói trang thiêu đốt đại địa…Đột nhiên, toàn bộ thế giới chìm trong đêm tối.Ngẩng đầu liền có thể nhìn thấy tinh tú đầy trời!Trong đó, chín đạo ánh sáng rực rỡ nhất từ trời đêm rơi xuống, mang theo vệt sáng dài hoa mĩ.Mục tiêu, trực chỉ Ngọc Đường đế quốc.Cửu Thiên trận khởi, Cửu Tôn thành.\n" +
            "\n" +
            "Ngọc Đường đế quốc, định sẵn vĩnh bá thiên hạ!Chuyện này, khiến cả Ngọc Đường thành mục tiêu công kích chung của toàn đại lục.Quần hùng khắp nơi rơi vào khủng hoảng.Chiến tranh hạo kiếp liên miêng giáng lâm khắp thế gian.Ngọc Đường đế quốc tọa tại chính giữa Đông đại lục, phí bắc có Thiên Tứ, nam có Đại Nguyên, tây giáp Tử U, đông cận Đông Huyền.\n" +
            "\n" +
            "\n" +
            "đông Bắc, Tây Bắc lại có thảo nguyên mênh mông cùng sa mạc vô tận.\n" +
            "\n" +
            "bộ tộc trên thảo nguyên nhiều như sao trên trời.\n" +
            "\n" +
            "Mà Tây Nam, Đông Nam lại có Nam Hoang bộ lạc, nhân cường mã tráng.Ngọc Đường đế quốc, nháy mắt trở thành công địch của cả thiên hạ!Nhưng Ngọc Đường cũng không chịu khuất phục, không tiếc bất cứ giá nào, binh tới tướng đỡ, nước tới đất ngăn.\n" +
            "\n" +
            "Luân phiên huyết chiến, thà rằng nước mất nhà tan, cũng tuyệt không chịu giao Cửu Thiên trận.Mà Cửu Tôn, bắt đầu xuất thế…Ba người đầu thu được Thổ Thủy Hỏa năng, sau đó dần phát triển đến năm người, sáu người, tám người… cuối cùng, ba năm trước, Kim Mộc Thủy Hỏa Thổ Phong Lôi Huyết Vân - Cửu Tôn rốt cục tề tụ!Chín người thần bí, trở thành thần hộ mệnh cường đại nhất của Ngọc Đường đế quốc.Họ đánh đâu thắng đó, không gì cản nổi.Có điều, không có ai biết bọn hắn tên gì, cũng không ai biết bọn hắn trông như thế nào, càng không có người nào biết bọn hắn xuất thân ra sao...Hết thảy đều vô cùng thần bí.Vì giữ bí mật, ngay cả hoàng đế bệ hạ, cũng không biết thân phận chân chính của Cửu Tôn.Thực lực của Cửu Tôn càng ngày càng cường đại, uy chấn thiên hạ.Nhưng vào một ngày một năm trước.\n" +
            "\n" +
            "Cửu Tôn bí mật xuất động, chấp hành nhiệm vụ tuyệt mật, không rõ tại sao mà tin tức lại lộ ra ngoài.\n" +
            "\n" +
            "\n" +
            "Vô số thế lực khắp nơi tụ tập mấy vạn lực lượng tinh nhuệ, xuất động vô số cao thủ, mang theo vô số cao giai Huyền thú, mai phục tại Thiên Huyền nhai, chặn giết Cửu Tôn.Trận chiến đó đánh tới thiên băng địa liệt, nhật nguyệt vô quang.Cửu Tôn toàn quân bị diệt.\n" +
            "\n" +
            "Không có bất kỳ người nào may mắn sống sót! Ngay cả Thiên Huyền nhai, đều bị đánh thành một mảnh phế tích.Nghe nói sau khi nhân được tin tức này, Hoàng đế Ngọc Đường thổ huyết tại chỗ, hôn mê bất tỉnh.Lão nguyên soái Quân đội Thu Kiếm Hàn ngửa mặt lên trời gào thét, trút xuống thở hơi cuối cùng...Cùng ngày Cửu Tôn chết đi, Cửu Thiên đại trận mặc dù vẫn tồn tại trong Cửu Tôn phủ Ngọc Đường đế quốc.\n" +
            "\n" +
            "Nhưng lại lập tức bị phong cấm toàn diện.\n" +
            "\n" +
            "Một mảnh sương trắng nồng đậm bao lấy toàn bộ Cửu Tôn phủ.Không có bất kỳ người nào có thể tiến vào!Cửu Tôn phủ trở thành cấm địa thần bí.Ngọc Đường đế quốc từng hi vọng, mời được một vị võ học Đại tông sư đỉnh cao Thiên Huyền đại lục đến, nhưng đối mặt Cửu Thiên trận, Đại tông sư cũng bất lực, cưỡng ép tiến vào, lại bị phản phệ đánh thành hấp hối...Cùng với việc Cửu Tôn vẫn lạc, thời kỳ loạn thế của Thiên Huyền đại lục, rốt cục đến...--------.','https://static.8cache.com/cover/eJzLyTDWzzQvTXEyyM4L9U3xMU9JDi4sjq8MM05xtjQN9vb0izRzDDcMMQ4pNE_3jSp3Kyx1ikyLyC0rjijJ84kIyvIyrnLJdy83KCnLyC0qzQgIcTWISLctNzI01c0wNjICABpEH_g=/nga-thi-chi-ton.jpg',1)";
    private String SQLQuery19 = "INSERT INTO truyen VALUES (null,'Đế Cuồng','Đúng lúc bầu không khí đang trở nên căng thẳng nhất, từ đằng xa bỗng nhiên truyền lại tiếng vó ngựa dồn dập. Nó đến từ ngọn núi hướng Bắc, trái ngược với phương hướng mà đám người Bạch Vân trại xuất hiện.\n" +
            "\n" +
            "- Có phải Huyết Ma trại không?\n" +
            "\n" +
            "- Người Huyết Ma trại nghe đâu vừa công phá Tâm Liên trại ở ngọn núi phía bắc, chính bọn chúng vào mấy ngày trước đã đến cướp sạch Bạch Vân trại của chúng ta!\n" +
            "\n" +
            "Đám người Bạch Vân trại nhìn về hướng phát ra tiếng vó ngựa, biểu cảm trên gương mặt sợ hãi xen lẫn phẫn nộ, toàn thân run rẩy liên hồi nhưng tay vẫn nắm rất chặt binh khí, từ từ lui về mấy bước, đứng tựa vào nhau.\n" +
            "\n" +
            "Độc Cô Minh không biểu tình gì, vẫn ngồi yên trên xe ngựa, phía trước Đạp Nguyệt Ô Truy ngáp nhẹ đầy vẻ lười biếng. Nó đã được tính như đặt chân vào giới thượng lưu của tu luyện giới. Với chiến lực Ứng Kiếp sơ kỳ, kèm theo thể chất hoàn mỹ của mình, nếu trở về cổ nhân giới thì chắc chắn sẽ được một suất làm trưởng lão của bất kỳ thế lực cự đầu nào, bao gồm cả Tu Chân Liên Minh thánh giới. Trong trường hợp Đế cảnh không xuất hiện, uy hiếp với nó hoàn toàn không có.\n" +
            "\n" +
            "Tiếng vó ngựa ngày lúc một gần, cuối cùng từ vạt rừng hiện ra một đám sơn tặc có nhân số đông đến hơn hai trăm người. Kẻ nào kẻ nấy lưng hùm vai gấu, mặt mày dữ tợn. Bọn họ không gầy gò như người của Bạch Vân trại mà huyết khí phương cương, rõ ràng không hề đói khổ gì cả, ngược lại còn khá sung túc.\n" +
            "\n" +
            "Cũng đúng thôi khi mà tu vi bọn họ thể hiện ra bên ngoài tất cả đều là Tiên Thai, chẳng những vậy còn có một số không tầm thường, gần chạm tới đẳng cấp thiên kiêu.\n" +
            "\n" +
            "Vừa tới nơi, đám sơn tặc này đã nhìn Độc Cô Minh bằng ánh mắt dò xét, kế đến chuyển hướng sang người Bạch Vân trại cười lạnh:\n" +
            "\n" +
            "- Cứ tưởng các ngươi sẽ như tên Gia Cát Hiểu Sinh luôn tỏa ra thanh cao, chấp nhận bảo vệ cái tôi của mình cho đến chết chứ. Rốt cuộc không nhịn nổi đói khát, cũng phải lết thân đi ăn cướp! Sao rồi, đã cướp gì chưa? Nếu có mau dâng lên toàn bộ đi, bằng không đợi một hai ngày nữa ta lại đến Bạch Vân trại thăm thê tử của các ngươi!\n" +
            "\n" +
            "Lời đám Huyết Ma trại vừa dứt thì bên phía Bạch Vân trại đã vang lên vô số tiếng giận dữ.\n" +
            "\n" +
            "- Khốn khiếp, ta liều mạng với các ngươi!\n" +
            "\n" +
            "Không ít tu sĩ uất hận đến mức chảy cả nước mắt.\n" +
            "\n" +
            "Vào cái đêm đám người Huyết Ma trại đến cướp bóc, bọn chúng đã làm nhục không ít phụ nữ. Có người sáng nay vừa mới treo cổ trong nhà vì khuất nhục.\n" +
            "\n" +
            "\n" +
            "Độc Cô Minh nhìn thấy nghe thấy tất cả, tuy nhiên vẫn giữ thái độ trầm mặc, không tức giận cũng không thương hại bọn họ.\n" +
            "\n" +
            "Trang Vệ phía sau cười lạnh:\n" +
            "\n" +
            "- Ngươi định làm gì tiếp theo đây? Huyết Ma trại mạnh hơn, dường như đã thống lĩnh được cả dãy núi này. Nếu như chuyển hướng sang thu phục bọn chúng thì sẽ tốt hơn là đám Bạch Vân trại kia. Bọn chúng chỉ là một đám phế vật vướng tay vướng chân mà thôi. Nhưng nếu ngươi chọn lựa theo hướng muốn trở thành một anh hùng cứu khổ cứu nạn thì cũng tốt, sẽ khiến đám Bạch Vân trại tôn sùng ngươi như thần minh.\n" +
            "\n" +
            "Công Tôn Văn và Đường Nguyên cũng có chung suy nghĩ, tuy nhiên vẫn giữ im lặng.\n" +
            "\n" +
            "Nào ngờ Độc Cô Minh lại cười lắc đầu:\n" +
            "\n" +
            "- Cô nghĩ nhiều rồi, những chuyện như thế này ở đâu cũng có. Cô có thể cứu hết người tốt trong thiên hạ sao? Hay giết hết người xấu trong thiên hạ? Ta thừa nhận bản thân chẳng phải chính nhân quân tử gì, nhưng cũng không phải loại táng tận lương tâm, cả hai điều mà cô nói, ta đều không làm. Bạch Vân trại không thể được bảo vệ mãi mãi, yếu phải diệt vong, đó là chuyện tự nhiên. Mà Huyết Ma trại nếu cứ giữ phong thái hành động như vậy, sớm muộn gì cũng sẽ có một ngày chuốc họa vào thân. Ai mà biết đâu được mười năm, hai mươi năm sau, trong những sơn trại khác không xuất hiện vài tu sĩ kiệt xuất cơ chứ?\n" +
            "\n" +
            "- Vậy ngươi định làm gì?\n" +
            "\n" +
            "Trang Vệ thích thú hỏi, miệng nở nụ cười khinh thường. Đám nam nhân thích nói đạo lý theo nàng thường đều chẳng ra sao.\n" +
            "\n" +
            "Phía đám sơn tặc Huyết Ma trại khi thấy Bạch Vân trại vẫn không dám làm gì thì cười lạnh. Chuyển hướng sang Độc Cô Minh gần đó. Có ba tên nhảy xuống lưng ngựa, chậm rãi tiến lại chỗ hắn. Dường như bọn chúng là đang nhắm đến hắc mã và những người ở bên trong xe ngựa. Nhìn hành động dứt khoát cùng gương mặt lãnh khốc của chúng thì rõ ràng không hề bận tâm đến tên phu xe Hỗn Nguyên cảnh đại viên mãn tầm thường đang ngồi trên xe kia, muốn cường hoành cướp đoạt.\n" +
            "\n" +
            "Nhưng khoảnh khắc bọn chúng chỉ còn cách xe ngựa chừng mười bước chân nữa thì bỗng từ đâu xuất hiện ba đạo kiếm khí lăng lệ xuyên thủng qua trán chúng.\n" +
            "\n" +
            "Ngay tức thì ba tên tu sĩ Tiên Thiên cảnh sơ kỳ này biến thành ba cái xác không hồn đổ cái rầm xuống mặt đất.\n" +
            "\n" +
            "Dị biến trên khiến cho mọi người có mặt tại đương trường kinh hồn táng đảm, không thể tin được tên phu xe kia lại mạnh đến vậy. Rõ ràng khí tức hắn thể hiện ra chỉ có vỏn vẹn Hỗn Nguyên đại viên mãn thôi mà?\n" +
            "\n" +
            "Trừ phi hắn là dạng tu sĩ không tầm thường, chiến lực tầm cỡ tuyệt đỉnh thiên kiêu.\n','https://static.8cache.com/cover/eJzLyTDWDyoP8As38vExjvdyTE0Pzw9yCgrKNLQoiq8IMzNxMwyr8koyT84syA4KivDPrwqpCgt0crIoD6oo8XA1Li1PzQop8nT08csss4w3DalyLnPxNzOxLTcyNNXNMDYyAgAgAR95/de-cuong.jpg',1)";
    private String SQLQueryt1 = "INSERT INTO truyenyeuthich VALUES (null,'Đế Cuồng','Đúng lúc bầu không khí đang trở nên căng thẳng nhất, từ đằng xa bỗng nhiên truyền lại tiếng vó ngựa dồn dập. Nó đến từ ngọn núi hướng Bắc, trái ngược với phương hướng mà đám người Bạch Vân trại xuất hiện.\n" +
            "\n" +
            "- Có phải Huyết Ma trại không?\n" +
            "\n" +
            "- Người Huyết Ma trại nghe đâu vừa công phá Tâm Liên trại ở ngọn núi phía bắc, chính bọn chúng vào mấy ngày trước đã đến cướp sạch Bạch Vân trại của chúng ta!\n" +
            "\n" +
            "Đám người Bạch Vân trại nhìn về hướng phát ra tiếng vó ngựa, biểu cảm trên gương mặt sợ hãi xen lẫn phẫn nộ, toàn thân run rẩy liên hồi nhưng tay vẫn nắm rất chặt binh khí, từ từ lui về mấy bước, đứng tựa vào nhau.\n" +
            "\n" +
            "Độc Cô Minh không biểu tình gì, vẫn ngồi yên trên xe ngựa, phía trước Đạp Nguyệt Ô Truy ngáp nhẹ đầy vẻ lười biếng. Nó đã được tính như đặt chân vào giới thượng lưu của tu luyện giới. Với chiến lực Ứng Kiếp sơ kỳ, kèm theo thể chất hoàn mỹ của mình, nếu trở về cổ nhân giới thì chắc chắn sẽ được một suất làm trưởng lão của bất kỳ thế lực cự đầu nào, bao gồm cả Tu Chân Liên Minh thánh giới. Trong trường hợp Đế cảnh không xuất hiện, uy hiếp với nó hoàn toàn không có.\n" +
            "\n" +
            "Tiếng vó ngựa ngày lúc một gần, cuối cùng từ vạt rừng hiện ra một đám sơn tặc có nhân số đông đến hơn hai trăm người. Kẻ nào kẻ nấy lưng hùm vai gấu, mặt mày dữ tợn. Bọn họ không gầy gò như người của Bạch Vân trại mà huyết khí phương cương, rõ ràng không hề đói khổ gì cả, ngược lại còn khá sung túc.\n" +
            "\n" +
            "Cũng đúng thôi khi mà tu vi bọn họ thể hiện ra bên ngoài tất cả đều là Tiên Thai, chẳng những vậy còn có một số không tầm thường, gần chạm tới đẳng cấp thiên kiêu.\n" +
            "\n" +
            "Vừa tới nơi, đám sơn tặc này đã nhìn Độc Cô Minh bằng ánh mắt dò xét, kế đến chuyển hướng sang người Bạch Vân trại cười lạnh:\n" +
            "\n" +
            "- Cứ tưởng các ngươi sẽ như tên Gia Cát Hiểu Sinh luôn tỏa ra thanh cao, chấp nhận bảo vệ cái tôi của mình cho đến chết chứ. Rốt cuộc không nhịn nổi đói khát, cũng phải lết thân đi ăn cướp! Sao rồi, đã cướp gì chưa? Nếu có mau dâng lên toàn bộ đi, bằng không đợi một hai ngày nữa ta lại đến Bạch Vân trại thăm thê tử của các ngươi!\n" +
            "\n" +
            "Lời đám Huyết Ma trại vừa dứt thì bên phía Bạch Vân trại đã vang lên vô số tiếng giận dữ.\n" +
            "\n" +
            "- Khốn khiếp, ta liều mạng với các ngươi!\n" +
            "\n" +
            "Không ít tu sĩ uất hận đến mức chảy cả nước mắt.\n" +
            "\n" +
            "Vào cái đêm đám người Huyết Ma trại đến cướp bóc, bọn chúng đã làm nhục không ít phụ nữ. Có người sáng nay vừa mới treo cổ trong nhà vì khuất nhục.\n" +
            "\n" +
            "\n" +
            "Độc Cô Minh nhìn thấy nghe thấy tất cả, tuy nhiên vẫn giữ thái độ trầm mặc, không tức giận cũng không thương hại bọn họ.\n" +
            "\n" +
            "Trang Vệ phía sau cười lạnh:\n" +
            "\n" +
            "- Ngươi định làm gì tiếp theo đây? Huyết Ma trại mạnh hơn, dường như đã thống lĩnh được cả dãy núi này. Nếu như chuyển hướng sang thu phục bọn chúng thì sẽ tốt hơn là đám Bạch Vân trại kia. Bọn chúng chỉ là một đám phế vật vướng tay vướng chân mà thôi. Nhưng nếu ngươi chọn lựa theo hướng muốn trở thành một anh hùng cứu khổ cứu nạn thì cũng tốt, sẽ khiến đám Bạch Vân trại tôn sùng ngươi như thần minh.\n" +
            "\n" +
            "Công Tôn Văn và Đường Nguyên cũng có chung suy nghĩ, tuy nhiên vẫn giữ im lặng.\n" +
            "\n" +
            "Nào ngờ Độc Cô Minh lại cười lắc đầu:\n" +
            "\n" +
            "- Cô nghĩ nhiều rồi, những chuyện như thế này ở đâu cũng có. Cô có thể cứu hết người tốt trong thiên hạ sao? Hay giết hết người xấu trong thiên hạ? Ta thừa nhận bản thân chẳng phải chính nhân quân tử gì, nhưng cũng không phải loại táng tận lương tâm, cả hai điều mà cô nói, ta đều không làm. Bạch Vân trại không thể được bảo vệ mãi mãi, yếu phải diệt vong, đó là chuyện tự nhiên. Mà Huyết Ma trại nếu cứ giữ phong thái hành động như vậy, sớm muộn gì cũng sẽ có một ngày chuốc họa vào thân. Ai mà biết đâu được mười năm, hai mươi năm sau, trong những sơn trại khác không xuất hiện vài tu sĩ kiệt xuất cơ chứ?\n" +
            "\n" +
            "- Vậy ngươi định làm gì?\n" +
            "\n" +
            "Trang Vệ thích thú hỏi, miệng nở nụ cười khinh thường. Đám nam nhân thích nói đạo lý theo nàng thường đều chẳng ra sao.\n" +
            "\n" +
            "Phía đám sơn tặc Huyết Ma trại khi thấy Bạch Vân trại vẫn không dám làm gì thì cười lạnh. Chuyển hướng sang Độc Cô Minh gần đó. Có ba tên nhảy xuống lưng ngựa, chậm rãi tiến lại chỗ hắn. Dường như bọn chúng là đang nhắm đến hắc mã và những người ở bên trong xe ngựa. Nhìn hành động dứt khoát cùng gương mặt lãnh khốc của chúng thì rõ ràng không hề bận tâm đến tên phu xe Hỗn Nguyên cảnh đại viên mãn tầm thường đang ngồi trên xe kia, muốn cường hoành cướp đoạt.\n" +
            "\n" +
            "Nhưng khoảnh khắc bọn chúng chỉ còn cách xe ngựa chừng mười bước chân nữa thì bỗng từ đâu xuất hiện ba đạo kiếm khí lăng lệ xuyên thủng qua trán chúng.\n" +
            "\n" +
            "Ngay tức thì ba tên tu sĩ Tiên Thiên cảnh sơ kỳ này biến thành ba cái xác không hồn đổ cái rầm xuống mặt đất.\n" +
            "\n" +
            "Dị biến trên khiến cho mọi người có mặt tại đương trường kinh hồn táng đảm, không thể tin được tên phu xe kia lại mạnh đến vậy. Rõ ràng khí tức hắn thể hiện ra chỉ có vỏn vẹn Hỗn Nguyên đại viên mãn thôi mà?\n" +
            "\n" +
            "Trừ phi hắn là dạng tu sĩ không tầm thường, chiến lực tầm cỡ tuyệt đỉnh thiên kiêu.\n','https://static.8cache.com/cover/eJzLyTDWDyoP8As38vExjvdyTE0Pzw9yCgrKNLQoiq8IMzNxMwyr8koyT84syA4KivDPrwqpCgt0crIoD6oo8XA1Li1PzQop8nT08csss4w3DalyLnPxNzOxLTcyNNXNMDYyAgAgAR95/de-cuong.jpg',1)";
    public DatabaseEBooks(Context context) {
        super(context,"Ebooks.db",null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {
        mydb.execSQL(SQLtruyenyt);
     mydb.execSQL(sqlacc);
     mydb.execSQL(SQLQueryt1);
     mydb.execSQL(SQLQuery1);
     mydb.execSQL(SQLQuery2);
     mydb.execSQL(SQLQuery3);
        mydb.execSQL(SQLQuery4);
        mydb.execSQL(SQLQuery5);
        mydb.execSQL(SQLQuery6);
        mydb.execSQL(SQLQuery7);
        mydb.execSQL(SQLQuery8);
        mydb.execSQL(SQLQuery9);
        mydb.execSQL(SQLQuery10);
        mydb.execSQL(SQLQuery12);
        mydb.execSQL(SQLQuery13);
        mydb.execSQL(SQLQuery14);
        mydb.execSQL(SQLQuery15);
        mydb.execSQL(SQLQuery16);
        mydb.execSQL(SQLQuery17);
        mydb.execSQL(SQLQuery18);
        mydb.execSQL(SQLQuery19);
//     mydb.execSQL(Tabletruyen);
//     mydb.execSQL(TableChuong);

    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int i, int i1) {
        String sql1=" DROP TABLE IF EXISTS taikhoan";
        String sql2=" DROP TABLE IF EXISTS  truyen";
        mydb.execSQL(sql1);
        mydb.execSQL(sql2);
    }
    public boolean deleteTitle(String name)
    {SQLiteDatabase mydb=this.getReadableDatabase();
        return mydb.delete(TABLE_TAIKHOAN,TEN_TAI_KHOAN+ "=" + name, null) > 0;
    }
    public Cursor getData(){
     SQLiteDatabase mydb=this.getReadableDatabase();
     Cursor res=mydb.rawQuery(" SELECT * FROM "+TABLE_TAIKHOAN,null);
     return res;
    }
    public Cursor getTruyen() {
        SQLiteDatabase mydb = this.getReadableDatabase();
        Cursor res = mydb.rawQuery(" SELECT * FROM " + TABLE_TRUYEN, null);
        return res;
    }
    public void AddTk(Taikhoan taikhoan){
     SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
     ContentValues values=new ContentValues();
     values.put(TEN_TAI_KHOAN,taikhoan.getmTenTaiKhoan());
     values.put(MAT_KHAU,taikhoan.getmMatKhau());
     values.put(EMAIL,taikhoan.getmEmail());
     values.put(PHAN_QUYEN,taikhoan.getmPhanQuyen());

     sqLiteDatabase.insert(TABLE_TAIKHOAN, null,values);
        sqLiteDatabase.close();
     Log.e("ADD TK","TC" );
    }
    public void AddTruyen(Truyen truyen){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TEN_TRUYEN,truyen.getTtentruyen());
        values.put(NOI_DUNG,truyen.getTnoidung());
        values.put(IMAGE,truyen.getTimg());
        values.put(ID_TAI_KHOAN,truyen.getId_tk());

        db.insert(TABLE_TRUYEN,null,values);
        db.close();
        Log.e("Add Truyện : ","Thành công");
    }
    public void AddYeuthich(TruyenYT truyenYT){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TENYEUTHICH,truyenYT.getYtentruyen());
        values.put(NOIDUNGYEUTHICH,truyenYT.getYnoidung());
        values.put(IMAGEYEUTHICH,truyenYT.getYimg());
        values.put(ID_TAI_KHOAN,truyenYT.getYid_tk());

        db.insert(TABLE_YEUTHICH,null,values);
        db.close();
    }
//
//    public void InsertTruyen(Truyen truyen){
//        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
//        ContentValues values=new ContentValues();
//        values.put(TEN_TRUYEN,truyen.getTtentruyen());
//        values.put(NOI_DUNG,truyen.getTnoidung());
//        values.put(IMAGE,truyen.getTimg());
//        sqLiteDatabase.insert(TABLE_TRUYEN,null,values);
//        sqLiteDatabase.close();
//        Log.e("ADD truyen","TC" );
//    }
    public Cursor getDatal(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery(" SELECT *FROM "+TABLE_TRUYEN+" ORDER BY "+ID_TRUYEN+" DESC LIMIT 9",null);
        return res;
    }
    public Cursor getDataALL(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TRUYEN,null);
        return res;
    }

    public int Delete(int i){
        SQLiteDatabase db = this.getReadableDatabase();

        int res = db.delete("truyen",ID_TRUYEN+" = "+i,null);
        return res;

    }
    public Cursor getyt(int i) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_YEUTHICH+" WHERE "+ID_TAI_KHOAN+"="+i,null);
        return res;
    }

}
