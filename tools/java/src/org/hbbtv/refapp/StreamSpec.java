package org.hbbtv.refapp;

/**
 * Simple structure for output stream properties.
 */
public class StreamSpec implements Cloneable {
	public static enum TYPE { VIDEO_H264, VIDEO_H265, AUDIO_AAC };
	
	public TYPE type;
	public String name;		// v1, v2, v3, a1 (segment_*.mp4|m4s name prefix)
	public String size;		// 1280x720, 1920x1080, 3840x2160
	public String bitrate;	// 128k, 500k, 1500k, 2500k
	public int sampleRate;	// 44100, 48000	 (audio sample rate)
	public int channels;	// 2 (audio channel count)
	public boolean enabled;
	
	public String profile;	// h264: main, h265: main
	public String level; 	// h264: 4.0,  h265: 5.0
	
	public int getWidth() {
		int idx=size.indexOf('x');
		return Integer.parseInt(size.substring(0, idx));
	}
	
	public String getCodec() {
		String val = type.toString();
		int idx=val.indexOf('_');
		return idx>0 ? val.substring(idx+1) : val;
	}

	@Override protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
