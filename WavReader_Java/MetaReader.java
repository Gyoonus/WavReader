import wave.WavHeader;
import wave.WavHeaderReader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Console utility for reading meta data of the wave files
 */
public class MetaReader {
    public static void main(String[] args) {
        /*
        if (args.length == 0) {
            System.out.println("Illegal command line arguments.\n" +
                    "Usage MetaReader\n\t MetaReader <source file path>");
            return;
        }

        */
        WavHeader wavHeader;
        try {
            //WavHeaderReader wavHeaderReader = new WavHeaderReader(args[0]);
            WavHeaderReader wavHeaderReader = new WavHeaderReader("/home/gyoo/test1234.wav");
            wavHeader = wavHeaderReader.read();
            String subchunk = new String(wavHeader.getSubChunk2ID());

            if(subchunk.equals("data") || subchunk.equals("DATA"))
            {
                System.out.println("supported File Format");
            }
            else
            {
                System.out.println("Unsupported File Format");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File " + args[0] + " not found!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
