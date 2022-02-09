package ru.kpfu.itis.speaker;

public class SpeakerBluetoothImpl implements Speaker {
    @Override
    public void out() {
        System.out.println("Воспроизодим через блютуз");
    }
}
