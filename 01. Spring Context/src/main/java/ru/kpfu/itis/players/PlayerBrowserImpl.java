package ru.kpfu.itis.players;

public class PlayerBrowserImpl implements Player {
    @Override
    public void playAudio(String text) {
        System.out.println("Проигрывание через бразуер " + text);
    }
}
