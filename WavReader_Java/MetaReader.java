import wave.WavHeader;
import wave.WavHeaderReader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Console utility for reading meta data of the wave files
 */
public class MetaReader {

    public int wav_checker (String wav_path, int channel_cnt, int sample_rate) {
        WavHeader wavHeader;
        try {
            //WavHeaderReader wavHeaderReader = new WavHeaderReader(args[0]);
            WavHeaderReader wavHeaderReader = new WavHeaderReader(wav_path);
            wavHeader = wavHeaderReader.read();

            //Can Erase
            System.out.println(wavHeader.toString());


        } catch (FileNotFoundException e) {
            System.out.println("Error: File " + wav_path + " not found!");
            return -1;
        } catch (IOException e) {
            return -9999;
        }

        if(wavHeader.getNumChannels() != channel_cnt){
            System.out.println("API Request channel = " + channel_cnt + "wav file channel Count = " +wavHeader.getNumChannels() + "is Different!");
            return -3;
        }

        if(wavHeader.getBitsPerSample() != 16) {
            System.out.println("bits per sample = " + wavHeader.getBitsPerSample() + "  is not supported!");
            return -4;
        }

        if(wavHeader.getSampleRate() != sample_rate) {
            System.out.println("API Request Sample Rate = " + sample_rate + "wav file channel = " +wavHeader.getNumChannels() + "is Different");
            return -5;
        }

        return 1;
    }


    public static void main(String[] args) {
        MetaReader meta = new MetaReader();
        int error = meta.wav_checker("/home/gyoo/test1234.wav", 1, 8000);
        System.out.println(error);


    }
}
