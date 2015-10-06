package example_event_dispatcher.events;


import example_event_dispatcher.core.PipelineEventDispatcher;

public class ExampleEvent {

  private String message;
  private PipelineEventDispatcher pipelineEventDispatcher;

  public ExampleEvent(String message, PipelineEventDispatcher pipelineEventDispatcher) {
    this.message = message;
    this.pipelineEventDispatcher = pipelineEventDispatcher;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public PipelineEventDispatcher getPipelineEventDispatcher() {
    return pipelineEventDispatcher;
  }

  public void setPipelineEventDispatcher(PipelineEventDispatcher pipelineEventDispatcher) {
    this.pipelineEventDispatcher = pipelineEventDispatcher;
  }
}
