import { registerPlugin } from '@capacitor/core';
import { SmsReaderPlugin } from './definitions';

/**
 * Register the SmsReader plugin.
 */
const SmsReader = registerPlugin<SmsReaderPlugin>('SmsReader', {
  web: () => import('./web').then(m => new m.SmsReaderWeb()),
});

export * from './definitions';
export { SmsReader };
