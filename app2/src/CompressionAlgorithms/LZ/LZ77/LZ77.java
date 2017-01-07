package CompressionAlgorithms.LZ.LZ77;

public class LZ77 {
	
	public static String encode(String input){
		LZ77Encoder lz_encoder = new LZ77Encoder(input);
		return lz_encoder.getCompressedText();
	}
	
	public static String decode(String input){
		LZ77Decoder lz_decode = new LZ77Decoder(input);
		return lz_decode.getOutput();
	}
}
