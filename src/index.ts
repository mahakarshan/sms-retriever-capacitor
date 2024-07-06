import { registerPlugin } from '@capacitor/core';

import type { smsPlugin } from './definitions';

const sms = registerPlugin<smsPlugin>('sms', {
  web: () => import('./web').then(m => new m.smsWeb()),
});

export * from './definitions';
export { sms };
