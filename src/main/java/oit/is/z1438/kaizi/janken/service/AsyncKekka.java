package oit.is.z1438.kaizi.janken.service;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.z1438.kaizi.janken.model.Match;
import oit.is.z1438.kaizi.janken.model.MatchMapper;

@Service
public class AsyncKekka {

  private final Logger logger = LoggerFactory.getLogger(AsyncKekka.class);

  @Autowired
  private MatchMapper matchMapper;

  public ArrayList<Match> syncCheckActiveMatch() {
    return matchMapper.selectActiveMatche();
  }

  @Async
  public void asyncCheckActiveMatch(SseEmitter emitter) {
    try {
      while (true) {
        TimeUnit.MILLISECONDS.sleep(500);
        ArrayList<Match> match = this.syncCheckActiveMatch();
        if (match == null || match.size() == 0) {
          continue;
        }
        emitter.send(match);
        break;
      }
    } catch (Exception e) {
      // 例外の名前とメッセージだけ表示する
      logger.warn("Exception:" + e.getClass().getName() + ":" + e.getMessage());
    } finally {
      emitter.complete();
    }
    System.out.println("asyncCheckActiveMatch complete");
  }

}
