package ru.kpfu.itis.players;

public class PlayerFileImpl implements Player {
    @Override
    public void playAudio(String text) {
        System.out.println("Воспроизводим аудио из файла " + text);
    }
}
