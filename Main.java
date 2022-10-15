import oopWithKodlamaio.dataAccess.HibernateKursDao;
import oopWithKodlamaio.dataAccess.JdbcEğitmenDao;
import oopWithKodlamaio.dataAccess.JdbcKategoriDao;
import oopWithKodlamaioApp.business.EğitmenManager;
import oopWithKodlamaioApp.business.KategoriManager;
import oopWithKodlamaioApp.business.KursManager;
import oopWithKodlamaioApp.core.logging.DatabaseLogger;
import oopWithKodlamaioApp.core.logging.FileLogger;
import oopWithKodlamaioApp.core.logging.Logger;
import oopWithKodlamaioApp.core.logging.MailLogger;
import oopWithKodlamaioApp.entities.Eğitmen;
import oopWithKodlamaioApp.entities.Kategori;
import oopWithKodlamaioApp.entities.Kurs;

public class Main {

	public static void main(String[] args) throws Exception {
 
		Logger[] loggers = {new DatabaseLogger(), new FileLogger(), new MailLogger()};
		
		//KURSLAR
		
		Kurs kurs1= new Kurs("Yazılım Geliştirici Yetiştirme Kampı",250,"Engin Demiroğ");
		Kurs kurs2= new Kurs("Senior Yazılım Geliştirici Yetiştirme Kampı",-10,"Engin Demiroğ"); // kurs fiyatında dolayı çalışmaz
		Kurs kurs3= new Kurs("Yazılım Geliştirici Yetiştirme Kampı",250,"Engin Demiroğ"); // kursun isminin aynı olmasından dolayı çalışmaz
		
		KursManager kursManager = new KursManager(new HibernateKursDao(), loggers);
		
		kursManager.add(kurs1);
		kursManager.add(kurs2);
		kursManager.add(kurs3);
		
		//KATEGORİLER
		
		Kategori kategori1= new Kategori("Programlama");
		Kategori kategori2= new Kategori("Programlama"); // bu kısım kategori ismi tekrar edemeyeceğinde dolayı çalışmaz
		
		KategoriManager kategoriManager= new KategoriManager(new JdbcKategoriDao(), loggers);
		
		kategoriManager.add(kategori1);
		kategoriManager.add(kategori2);
		
		//EĞİTMENLER
		
		Eğitmen eğitmen1 = new Eğitmen("Engin Demiroğ");
		
		EğitmenManager eğitmenManager = new EğitmenManager(new JdbcEğitmenDao(), loggers);
		
		eğitmenManager.add(eğitmen1);
		
		
		
		
	}

}
