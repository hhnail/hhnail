import { defineConfig } from 'umi';

export default defineConfig({
  nodeModulesTransform: {
    type: 'none',
  },
  routes: [
    { path: '/', component: '@/pages/index' },
    // { path: '/products', component: '@/pages/products' },
  ],
  fastRefresh: {},
  proxy: {
    '/api01': {
      'target': 'http://localhost:8080/',
      'changeOrigin': true,
      'pathRewrite': { '/api01' : '' },
    },
  },
});
