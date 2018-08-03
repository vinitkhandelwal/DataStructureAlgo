package courseera;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.ROUND_HALF_EVEN;

/**
 * Created by vinit.khandelwal on 1/17/2018.
 */
public class Test {

    public static void main(String[] args) throws IOException {
//        System.setProperties("java.io.tmpdir","/opt/logs/templates/");
//        File file  = new DefaultTempFileCreationStrategy().createTempFile("poi-sxssf-sheet", ".xml");
//
//        new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

        double value = 1232251.0114156008;

        for(int i = 0 ; i <=7 ;i++){
            System.out.println(BigDecimal.valueOf(value).setScale(3, i).doubleValue());
        }


    }

    public static class DefaultTempFileCreationStrategy  {
        private  File dir;

        public DefaultTempFileCreationStrategy() {
            this((File)null);
        }

        public DefaultTempFileCreationStrategy(File dir) {
            this.dir = dir;
        }

        public  File createTempFile(String prefix, String suffix) throws IOException {
            if(this.dir == null) {
                this.dir = new File(System.getProperty("java.io.tmpdir"), "poifiles");
                System.out.println(System.getProperty("java.io.tmpdir"));
                System.out.println(System.getProperty("poi.keep.tmp.files"));
                System.out.println("Directory path :" +this.dir.getAbsolutePath());
                this.dir.mkdir();
                System.out.println("After reation Directory path :" +this.dir.getAbsolutePath());
                if(System.getProperty("poi.keep.tmp.files") == null) {
                    this.dir.deleteOnExit();
                    System.out.println("delete done of poifiles");
                }
            }

            File newFile = File.createTempFile(prefix, suffix, this.dir);
            System.out.println("temp file created");
            if(System.getProperty("poi.keep.tmp.files") == null) {
                newFile.deleteOnExit();
                System.out.println("delete done of poifiles after newFile");
            }

            return newFile;
        }
    }
}
