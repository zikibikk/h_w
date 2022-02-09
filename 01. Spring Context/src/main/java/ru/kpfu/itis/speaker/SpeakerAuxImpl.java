package ru.kpfu.itis.speaker;

public class SpeakerAuxImpl implements Speaker {
    @Override
    public void out() {
        System.out.println("Воспроизводим через AUX");
    }
}
