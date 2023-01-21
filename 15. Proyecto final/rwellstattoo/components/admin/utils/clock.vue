<template>
  <svg viewBox="0 0 40 40">
    <circle cx="20" cy="20" r="19" />
    <g class="marks">
      <line x1="15" y1="0" x2="16" y2="0" />
      <line x1="15" y1="0" x2="16" y2="0" />
      <line x1="15" y1="0" x2="16" y2="0" />
      <line x1="15" y1="0" x2="16" y2="0" />
      <line x1="15" y1="0" x2="16" y2="0" />
      <line x1="15" y1="0" x2="16" y2="0" />
      <line x1="15" y1="0" x2="16" y2="0" />
      <line x1="15" y1="0" x2="16" y2="0" />
      <line x1="15" y1="0" x2="16" y2="0" />
      <line x1="15" y1="0" x2="16" y2="0" />
      <line x1="15" y1="0" x2="16" y2="0" />
      <line x1="15" y1="0" x2="16" y2="0" />
    </g>
    <line x1="0" y1="0" x2="9" y2="0" class="hour" />
    <line x1="0" y1="0" x2="13" y2="0" class="minute" />
    <line x1="0" y1="0" x2="16" y2="0" class="seconds" />
    <circle cx="20" cy="20" r="0.7" class="pin" />
  </svg>
</template>

<script>
export default {
  name: 'Clock',
  mounted() {
    const svg = document.querySelector('svg')
    const currentTime = new Date()
    svg.style.setProperty('--start-seconds', currentTime.getSeconds())
    svg.style.setProperty('--start-minutes', currentTime.getMinutes())
    svg.style.setProperty('--start-hours', currentTime.getHours() % 12)
  }
}
</script>

<style scoped>
  svg {
    fill: none;
    stroke:  #6A1B9A;
    stroke-width: 1;
    stroke-linecap: round;
    transform: rotate(-90deg);
    --start-seconds: 57;
    --start-minutes: 45;
    --start-hours: 11;
  }

  circle {
    fill: white;
  }

  .marks {
    transform: translate(20px, 20px);
    stroke-width: 0.2;
    stroke:  #6A1B9A;
  }

  .seconds,
  .minute,
  .hour
  {
    transform: translate(20px, 20px) rotate(0deg);
  }

  .seconds {
    transform: translate(20px, 20px) rotate(calc(var(--start-seconds) * 6deg));
    stroke-width: 0.3;
    stroke:  #6A1B9A;
    animation: rotateSecondHand 60s steps(60) infinite;
    stroke:  #6A1B9A;
  }

  .minute {
    transform: translate(20px, 20px) rotate(calc(var(--start-minutes) * 6deg));
    stroke-width: 0.6;
    animation: rotateMinuteHand 3600s steps(60) infinite;
    animation-delay: calc(var(--start-seconds) * -1 * 1s);
  }

  .hour {
    transform: translate(20px, 20px) rotate(calc(var(--start-hours) * 30deg));
    animation: rotateHourHand calc(12 * 60 * 60s) linear infinite;
    stroke-width: 1;
    animation-delay: calc(calc(var(--start-minutes) * -60 * 1s) + calc(var(--start-seconds) * -1 * 1s));
  }

  .pin {
    stroke:  #6A1B9A;
    stroke-width: 0.2;
  }

  @keyframes rotateSecondHand {
    from {
      transform: translate(20px, 20px) rotate(calc(var(--start-seconds) * 6deg));
    }
    to {
      transform: translate(20px, 20px) rotate(calc(var(--start-seconds) * 6deg + 360deg));
    }
  }

  @keyframes rotateMinuteHand {
    from {
      transform: translate(20px, 20px) rotate(calc(var(--start-minutes) * 6deg));
    }
    to {
      transform: translate(20px, 20px) rotate(calc(var(--start-minutes) * 6deg + 360deg));
    }
  }

  @keyframes rotateHourHand {
    from {
      transform: translate(20px, 20px) rotate(calc(var(--start-hours) * 30deg));
    }
    to {
      transform: translate(20px, 20px) rotate(calc(var(--start-hours) * 30deg + 360deg));
    }
  }

  /* marks */
  .marks > line:nth-child(1) {
    transform: rotate(30deg);
  }

  .marks > line:nth-child(2) {
    transform: rotate(calc(2 * 30deg));
  }

  .marks > line:nth-child(3) {
    transform: rotate(calc(3 * 30deg));
    stroke-width: 0.5;
  }

  .marks > line:nth-child(4) {
    transform: rotate(calc(4 * 30deg));
  }
  .marks > line:nth-child(5) {
    transform: rotate(calc(5 * 30deg));
  }

  .marks > line:nth-child(6) {
    transform: rotate(calc(6 * 30deg));
    stroke-width: 0.5;
  }

  .marks > line:nth-child(7) {
    transform: rotate(calc(7 * 30deg));
  }

  .marks > line:nth-child(8) {
    transform: rotate(calc(8 * 30deg));
  }

  .marks > line:nth-child(9) {
    transform: rotate(calc(9 * 30deg));
    stroke-width: 0.5;
  }

  .marks > line:nth-child(10) {
    transform: rotate(calc(10 * 30deg));
  }

  .marks > line:nth-child(11) {
    transform: rotate(calc(11 * 30deg));
  }
  .marks > line:nth-child(12) {
    transform: rotate(calc(12 * 30deg));
    stroke-width: 0.5;
  }

</style>
