#ifndef RECEIVING_MINIGAME_HPP
#define RECEIVING_MINIGAME_HPP

#include <vector>
#include <string>

// ------------------- Timer -------------------
class Timer
{
private:
    int timeRemaining;

public:
    void start();
    void stop();
    void reset();
    void tick();
};

// ------------------- Settings -------------------
class Settings
{
private:
    bool colorBlindMode;
    int difficultyLevel;

public:
    void applySettings();
    void toggleColorBlindMode();
    bool getColorBlindMode() const;
    int getDifficultyLevel() const;
};

// ------------------- InputHandler -------------------
class InputHandler
{
public:
    void listenForMovement();
    void detectCatchKey();
};

// ------------------- GameUI -------------------
class GameUI
{
private:
    int scoreDisplay;
    int timeDisplay;
    int roundDisplay;

public:
    void updateUI();
    void showInstruction();
    void showResult();
};

// ------------------- ScoreManager -------------------
class ScoreManager
{
private:
    int totalScore;
    int comboStreak;

public:
    void calculatePoints(int pointValue);
    void resetScore();
    void applyCombo();
    int getScore() const;
};

// ------------------- RoundManager -------------------
class RoundManager
{
private:
    int roundTime;
    int roundNumber;

public:
    void startRound();
    void endRound();
    void increaseDifficulty();
    int getRoundNumber() const;
};

// ------------------- PlayerReceiver -------------------
class PlayerReceiver
{
private:
    int position;
    float speed;
    float catchSuccessRate;

public:
    void moveLeft();
    void moveRight();
    void catchFootball();
    int getPosition() const;
};

// ------------------- Football (Base) -------------------
class Football
{
protected:
    std::string color;
    float speed;
    int position;
    int pointValue;

public:
    virtual void move();
    virtual void onCatch();
    virtual bool isCatchable() const;
    int getPointValue() const;
};

// ------------------- BlueFootball -------------------
class BlueFootball : public Football
{
private:
    float bonusChance;

public:
    void onCatch() override;
};

// ------------------- YellowFootball -------------------
class YellowFootball : public Football
{
private:
    bool wobbleEffect;

public:
    void onCatch() override;
};

// ------------------- RedFootball -------------------
class RedFootball : public Football
{
private:
    std::string penaltyEffect;

public:
    void onCatch() override;
};

// ------------------- ReceivingGame -------------------
class ReceivingGame
{
private:
    int currentRound;
    int score;
    Timer timer;
    Settings settings;
    PlayerReceiver player;
    ScoreManager scoreManager;
    RoundManager roundManager;
    GameUI ui;
    InputHandler inputHandler;
    std::vector<Football *> footballs;

public:
    void startGame();
    void endGame();
    void spawnFootball();
    void updateScore(int value);
    void nextRound();
};

#endif // RECEIVING_MINIGAME_HPP
